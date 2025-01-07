package com.mweb.transacciones.service;

import com.mweb.transacciones.client.InventarioRestClient;
import com.mweb.transacciones.db.Cliente;
import com.mweb.transacciones.db.DetalleVenta;
import com.mweb.transacciones.db.Venta;
import com.mweb.transacciones.dtos.*;
import com.mweb.transacciones.repo.ClienteRepository;
import com.mweb.transacciones.repo.DetalleVentaRepository;
import com.mweb.transacciones.repo.VentaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class VentaService {

    @Inject
    @RestClient
    InventarioRestClient inventarioRestClient;

    @Inject
    VentaRepository ventaRepository;

    @Inject
    DetalleVentaRepository detalleVentaRepository;

    @Inject
    ClienteRepository clienteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Integer generarNumeroFactura(Long negocioId) {
        Query query = entityManager.createNativeQuery(
                "SELECT generar_numero_factura(:negocioId)");
        query.setParameter("negocioId", negocioId);
        return ((Number) query.getSingleResult()).intValue();
    }



    @Transactional
    public Response registrarVentas(VentaRequestDTO obj) {
        try {
            Venta venta = new Venta();
            Cliente cliente = clienteRepository.find("identificacion = ?1 and idNegocio = ?2", obj.getCliente(), obj.getIdNegocio()).firstResult();
            venta.setCliente(cliente != null ? cliente : null);
            List<DetalleVenta> listaDet = new ArrayList<>();

            for (ProductoCarritoDTO d : obj.getDetalles()) {
                try {
                    Response subproductoResponse = inventarioRestClient.obtenerSubproductoCodigoBarras(d.getCodigoBarras(), obj.getIdNegocio());
                    if (subproductoResponse.getStatus() == 200) {
                        SubproductoDTO subproductoDTO = subproductoResponse.readEntity(SubproductoDTO.class);
                        subproductoDTO.setStockActual(subproductoDTO.getStockActual() - d.getCantidad());
                        inventarioRestClient.actualizarSubproducto(subproductoDTO.getCodigoBarras(), subproductoDTO);

                        Response productoSR = inventarioRestClient.obtenerProductoCodigoBarras(subproductoDTO.getProducto(), obj.getIdNegocio());
                        ProductoDTO productoDTOS = productoSR.readEntity(ProductoDTO.class);
                        productoDTOS.setStockActual(subproductoDTO.getStockActual() / subproductoDTO.getCantidadRelacionada());
                        inventarioRestClient.actualizarProducto(productoDTOS.getCodigoBarras(), productoDTOS);

                        DetalleVenta detalleVenta = new DetalleVenta();
                        detalleVenta.setCantidad(d.getCantidad());
                        detalleVenta.setTotal(d.getSubtotal());
                        detalleVenta.setSubProductoCodigo(d.getCodigoBarras());
                        detalleVentaRepository.persist(detalleVenta);
                        listaDet.add(detalleVenta);
                    }
                } catch (WebApplicationException ex) {
                    if (ex.getResponse().getStatus() == 404) {
                        try {
                            Response productoResponse = inventarioRestClient.obtenerProductoCodigoBarras(d.getCodigoBarras(), obj.getIdNegocio());
                            if (productoResponse.getStatus() == 200) {
                                ProductoDTO productoDTO = productoResponse.readEntity(ProductoDTO.class);
                                productoDTO.setStockActual(productoDTO.getStockActual() - d.getCantidad());
                                inventarioRestClient.actualizarProducto(productoDTO.getCodigoBarras(), productoDTO);

                                DetalleVenta detalleVenta = new DetalleVenta();
                                detalleVenta.setCantidad(d.getCantidad());
                                detalleVenta.setTotal(d.getSubtotal());
                                detalleVenta.setProductoCodigo(d.getCodigoBarras());
                                detalleVentaRepository.persist(detalleVenta);
                                listaDet.add(detalleVenta);

                                try {
                                    Response subproductosR = inventarioRestClient.listaSubproductosPorProducto(productoDTO.getCodigoBarras(), obj.getIdNegocio());
                                    if (subproductosR.getStatus() == 200) {
                                        List<SubproductoDTO> subproductos = subproductosR.readEntity(new GenericType<List<SubproductoDTO>>() {
                                        });
                                        for (SubproductoDTO sub : subproductos) {
                                            sub.setStockActual(sub.getStockActual() - (sub.getCantidadRelacionada() * d.getCantidad()));
                                            inventarioRestClient.actualizarSubproducto(sub.getCodigoBarras(), sub);
                                        }
                                    }
                                } catch (WebApplicationException e) {
                                    if (e.getResponse().getStatus() != 404) {
                                        throw e;
                                    }
                                }
                            }
                        } catch (WebApplicationException e) {
                            if (e.getResponse().getStatus() == 404) {
                                return Response.status(Response.Status.NOT_FOUND).entity("Producto o subproducto no encontrado: " + d.getCodigoBarras()).build();
                            } else {
                                throw e;
                            }
                        }
                    } else {
                        throw ex;
                    }
                }
            }

            venta.setDetalles(listaDet);
            venta.setFecha(LocalDateTime.now());
            venta.setPagoTransferencia(obj.isPagoTransferencia());

            if (obj.getDescuento() == null || obj.getDescuento().getTipoDescuento() == null || obj.getDescuento().getValorDescuento() == 0) {
                venta.setTotal(obj.getTotal());
            } else {
                BigDecimal total = obj.getTotal();
                if (obj.getDescuento().getTipoDescuento()) {
                    total = total.subtract(total.multiply(new BigDecimal(obj.getDescuento().getValorDescuento())).divide(new BigDecimal(100)));
                } else {
                    total = total.subtract(new BigDecimal(obj.getDescuento().getValorDescuento()));
                }
                venta.setTotal(total);
            }

            venta.setActivo(true);
            venta.setIdCuadreCaja(obj.getIdCuadreCaja());
            venta.setIdNegocio(obj.getIdNegocio());
            venta.setUsername(obj.getUsername());


            Integer numeroReferencia = generarNumeroFactura(obj.getIdNegocio().longValue());
            venta.setNumeroReferencia(numeroReferencia);

            this.ventaRepository.persist(venta);

            for (DetalleVenta detalleVenta : listaDet) {
                detalleVenta.setVenta(venta);
            }

            return Response.ok("Venta generada con éxito").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al generar la venta").build();
        }
    }

    // Method to get all sales by cash register ID
    public List<VentaResumenDTO> obtenerVentasPorCuadreCaja(Integer idCuadreCaja) {
        TypedQuery<Venta> query = ventaRepository.getEntityManager().createQuery(
                "SELECT v FROM Venta v WHERE v.idCuadreCaja = :idCuadreCaja", Venta.class);
        query.setParameter("idCuadreCaja", idCuadreCaja);
        List<Venta> ventas = query.getResultList();

        return ventas.stream().map(venta -> {
            VentaResumenDTO dto = new VentaResumenDTO();
            dto.setFecha(venta.getFecha());
            dto.setTotal(venta.getTotal());
            dto.setNumeroReferencia(venta.getNumeroReferencia());
            dto.setPagoTransferencia(venta.getPagoTransferencia());
            return dto;
        }).collect(Collectors.toList());
    }

    // Method to get all details of a sale by reference number and business ID
    public VentaRequestDTO obtenerVentaPorNumeroReferenciaYNegocio(Integer numeroReferencia, Integer idNegocio) {
        TypedQuery<Venta> query = ventaRepository.getEntityManager().createQuery(
                "SELECT v FROM Venta v WHERE v.numeroReferencia = :numeroReferencia AND v.idNegocio = :idNegocio", Venta.class);
        query.setParameter("numeroReferencia", numeroReferencia);
        query.setParameter("idNegocio", idNegocio);
        Venta venta = query.getSingleResult();

        VentaRequestDTO dto = new VentaRequestDTO();
        dto.setCliente(venta.getCliente().getIdentificacion());
        dto.setUsername(venta.getUsername());
        dto.setPagoTransferencia(venta.getPagoTransferencia());
        dto.setTotal(venta.getTotal());
        dto.setIdCuadreCaja(venta.getIdCuadreCaja());
        dto.setIdNegocio(venta.getIdNegocio());

        List<ProductoCarritoDTO> detalles = venta.getDetalles().stream().map(detalle -> {
            ProductoCarritoDTO detalleDTO = new ProductoCarritoDTO();
            detalleDTO.setCantidad(detalle.getCantidad());
            detalleDTO.setCodigoBarras(detalle.getProductoCodigo());
            detalleDTO.setSubtotal(detalle.getTotal());
            return detalleDTO;
        }).collect(Collectors.toList());

        dto.setDetalles(detalles);
        return dto;
    }

    // Method to search sales by reference number, date range, and username
    public List<VentaResumenDTO> buscarVentas(Integer numeroReferencia, LocalDateTime fechaInicio, LocalDateTime fechaFin, String username, Integer idNegocio) {
        StringBuilder queryString = new StringBuilder("SELECT v FROM Venta v WHERE v.idNegocio = :idNegocio");
        if (numeroReferencia != null) {
            queryString.append(" AND v.numeroReferencia = :numeroReferencia");
        }
        if (fechaInicio != null && fechaFin != null) {
            queryString.append(" AND v.fecha BETWEEN :fechaInicio AND :fechaFin");
        }
        if (username != null) {
            queryString.append(" AND v.username = :username");
        }

        TypedQuery<Venta> query = ventaRepository.getEntityManager().createQuery(queryString.toString(), Venta.class);
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

        List<Venta> ventas = query.getResultList();
        return ventas.stream().map(venta -> {
            VentaResumenDTO dto = new VentaResumenDTO();
            dto.setFecha(venta.getFecha());
            dto.setTotal(venta.getTotal());
            dto.setNumeroReferencia(venta.getNumeroReferencia());
            dto.setPagoTransferencia(venta.getPagoTransferencia());
            return dto;
        }).collect(Collectors.toList());
    }

}