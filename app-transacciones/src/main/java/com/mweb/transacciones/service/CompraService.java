package com.mweb.transacciones.service;

import com.mweb.transacciones.client.InventarioRestClient;
import com.mweb.transacciones.repo.CompraRepository;
import com.mweb.transacciones.client.InventarioRestClient;
import com.mweb.transacciones.db.Compra;
import com.mweb.transacciones.db.DetalleCompra;
import com.mweb.transacciones.dtos.*;
import com.mweb.transacciones.repo.CompraRepository;
import com.mweb.transacciones.repo.DetalleCompraRepository;
import com.mweb.transacciones.repo.DetalleCompraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CompraService {

    @Inject
    @RestClient
    InventarioRestClient inventarioRestClient;

    @Inject
    CompraRepository compraRepository;

    @Inject
    DetalleCompraRepository detalleCompraRepository;



    @Transactional
    public Response registrarCompras(CompraRequestDTO obj) {
        try {
            Compra compra = new Compra();
            compra.setProveedorIdentificacion(obj.getProveedor());
            List<DetalleCompra> listaDet = new ArrayList<>();

            for (ProductoCarritoDTO d : obj.getDetalles()) {
                try {
                    Response productoResponse = inventarioRestClient.obtenerProductoPorCodigoBarrasYProveedor(d.getCodigoBarras(), obj.getProveedor(),obj.getIdNegocio());
                    if (productoResponse.getStatus() == 200) {
                        ProductoDTO productoDTO = productoResponse.readEntity(ProductoDTO.class);
                        productoDTO.setStockActual(productoDTO.getStockActual() + d.getCantidad());
                        inventarioRestClient.actualizarProducto(productoDTO.getCodigoBarras(), productoDTO);

                        DetalleCompra detalleCompra = new DetalleCompra();
                        detalleCompra.setCantidad(d.getCantidad());
                        detalleCompra.setTotal(d.getSubtotal());
                        detalleCompra.setProductoCodigo(d.getCodigoBarras());
                        detalleCompraRepository.persist(detalleCompra);
                        listaDet.add(detalleCompra);

                        // Check and update subproducts stock
                        try {
                            Response subproductosResponse = inventarioRestClient.listaSubproductosPorProductoYProveedor(productoDTO.getCodigoBarras(), obj.getProveedor(), obj.getIdNegocio());
                            if (subproductosResponse.getStatus() == 200) {
                                List<SubproductoDTO> subproductos = subproductosResponse.readEntity(new GenericType<List<SubproductoDTO>>() {
                                });
                                for (SubproductoDTO subproducto : subproductos) {
                                    subproducto.setStockActual(subproducto.getStockActual() + (subproducto.getCantidadRelacionada() * d.getCantidad()));
                                    inventarioRestClient.actualizarSubproducto(subproducto.getCodigoBarras(), subproducto);
                                }
                            }
                        } catch (WebApplicationException e) {
                            if (e.getResponse().getStatus() != 404) {
                                throw e;
                            }
                        }
                    }
                } catch (WebApplicationException ex) {
                    if (ex.getResponse().getStatus() == 404) {
                        return Response.status(Response.Status.NOT_FOUND).entity("Producto no encontrado: " + d.getCodigoBarras()).build();
                    } else {
                        throw ex;
                    }
                }
            }

            compra.setDetalles(listaDet);
            compra.setFecha(LocalDateTime.now());
            compra.setPagoTransferencia(obj.isPagoTransferencia());
            compra.setTotal(obj.getTotal());
            compra.setActivo(true);
            compra.setIdCuadreCaja(obj.getIdCuadreCaja());
            compra.setIdNegocio(obj.getIdNegocio());
            compra.setUsername(obj.getUsername());

            Integer maxIdentificador = (Integer) compraRepository.getEntityManager()
                    .createQuery("SELECT MAX(c.numeroReferencia) FROM Compra c WHERE c.idNegocio = :idNegocio")
                    .setParameter("idNegocio", obj.getIdNegocio())
                    .getSingleResult();
            compra.setNumeroReferencia(maxIdentificador == null ? 1 : maxIdentificador + 1);

            this.compraRepository.persist(compra);

            for (DetalleCompra detalleCompra : listaDet) {
                detalleCompra.setCompra(compra);
            }

            return Response.ok("Compra registrada con éxito").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al registrar la compra").build();
        }
    }


    public List<CompraResumenDTO> obtenerComprasPorCuadreCaja(Integer idCuadreCaja) {
        TypedQuery<Compra> query = compraRepository.getEntityManager().createQuery(
                "SELECT c FROM Compra c WHERE c.idCuadreCaja = :idCuadreCaja", Compra.class);
        query.setParameter("idCuadreCaja", idCuadreCaja);
        List<Compra> compras = query.getResultList();

        return compras.stream().map(compra -> {
            CompraResumenDTO dto = new CompraResumenDTO();
            dto.setFecha(compra.getFecha());
            dto.setTotal(compra.getTotal());
            dto.setNumeroReferencia(compra.getNumeroReferencia());
            dto.setPagoTransferencia(compra.getPagoTransferencia());
            return dto;
        }).collect(Collectors.toList());
    }

    // Method to get all details of a purchase by reference number and business ID
    public CompraRequestDTO obtenerCompraPorNumeroReferenciaYNegocio(Integer numeroReferencia, Integer idNegocio) {
        TypedQuery<Compra> query = compraRepository.getEntityManager().createQuery(
                "SELECT c FROM Compra c WHERE c.numeroReferencia = :numeroReferencia AND c.idNegocio = :idNegocio", Compra.class);
        query.setParameter("numeroReferencia", numeroReferencia);
        query.setParameter("idNegocio", idNegocio);
        Compra compra = query.getSingleResult();

        CompraRequestDTO dto = new CompraRequestDTO();
        dto.setProveedor(compra.getProveedorIdentificacion());
        dto.setUsername(compra.getUsername());
        dto.setPagoTransferencia(compra.getPagoTransferencia());
        dto.setTotal(compra.getTotal());
        dto.setIdCuadreCaja(compra.getIdCuadreCaja());
        dto.setIdNegocio(compra.getIdNegocio());

        List<ProductoCarritoDTO> detalles = compra.getDetalles().stream().map(detalle -> {
            ProductoCarritoDTO detalleDTO = new ProductoCarritoDTO();
            detalleDTO.setCantidad(detalle.getCantidad());
            detalleDTO.setCodigoBarras(detalle.getProductoCodigo());
            detalleDTO.setSubtotal(detalle.getTotal());
            return detalleDTO;
        }).collect(Collectors.toList());

        dto.setDetalles(detalles);
        return dto;
    }

    // Method to search purchases by reference number, date range, and username
    public List<CompraResumenDTO> buscarCompras(Integer numeroReferencia, LocalDateTime fechaInicio, LocalDateTime fechaFin, String username, Integer idNegocio) {
        StringBuilder queryString = new StringBuilder("SELECT c FROM Compra c WHERE c.idNegocio = :idNegocio");
        if (numeroReferencia != null) {
            queryString.append(" AND c.numeroReferencia = :numeroReferencia");
        }
        if (fechaInicio != null && fechaFin != null) {
            queryString.append(" AND c.fecha BETWEEN :fechaInicio AND :fechaFin");
        }
        if (username != null) {
            queryString.append(" AND c.username = :username");
        }

        TypedQuery<Compra> query = compraRepository.getEntityManager().createQuery(queryString.toString(), Compra.class);
        query.setParameter("idNegocio", idNegocio);
        if (numeroReferencia != null) {
            query.setParameter("numeroReferencia", numeroReferencia);
        }
        if (fechaInicio != null && fechaFin != null) {
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
        }
        if (username != null) {
            query.setParameter("username", username);
        }

        List<Compra> compras = query.getResultList();
        return compras.stream().map(compra -> {
            CompraResumenDTO dto = new CompraResumenDTO();
            dto.setFecha(compra.getFecha());
            dto.setTotal(compra.getTotal());
            dto.setNumeroReferencia(compra.getNumeroReferencia());
            dto.setPagoTransferencia(compra.getPagoTransferencia());
            return dto;
        }).collect(Collectors.toList());
    }
}