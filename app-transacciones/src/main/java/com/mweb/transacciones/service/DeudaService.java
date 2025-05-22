package com.mweb.transacciones.service;

import com.mweb.transacciones.client.InventarioRestClient;
import com.mweb.transacciones.db.Abono;
import com.mweb.transacciones.db.Cliente;
import com.mweb.transacciones.db.DetalleDeuda;
import com.mweb.transacciones.db.Deuda;
import com.mweb.transacciones.dtos.*;
import com.mweb.transacciones.repo.AbonoRepository;
import com.mweb.transacciones.repo.ClienteRepository;
import com.mweb.transacciones.repo.DetalleDeudaRepository;
import com.mweb.transacciones.repo.DeudaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class DeudaService {

    @Inject
    @RestClient
    InventarioRestClient inventarioRestClient;
    @Inject
    ClienteRepository clienteRepository;
    @Inject
    DeudaRepository deudaRepository;
    @Inject
    DetalleDeudaRepository detalleDeudaRepository;
    @Inject
    AbonoRepository abonoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Integer generarNumeroDeuda(Long negocioId) {
        Query query = entityManager.createNativeQuery(
                "SELECT generar_numero_deuda(:negocioId)");
        query.setParameter("negocioId", negocioId);
        return ((Number) query.getSingleResult()).intValue();
    }

    @Transactional
    public Response generarDeuda(DeudaDTO obj) {
        try {
            Deuda deuda = new Deuda();
            deuda.setEstado(true);

            deuda.setCliente(this.clienteRepository.find("identificacion = ?1 AND activo =?2 AND idNegocio = ?3", obj.getClienteId(), true, obj.getIdNegocio()).singleResult());
            List<DetalleDeuda> listaDet = new ArrayList<>();

            for (DetalleDeudaDTO d : obj.getDetalles()) {
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

                        DetalleDeuda detalleDeuda = new DetalleDeuda();
                        detalleDeuda.setCantidad(d.getCantidad());
                        detalleDeuda.setTotal(d.getSubtotal());
                        detalleDeuda.setSubProductoCodigo(d.getCodigoBarras());
                        detalleDeudaRepository.persist(detalleDeuda);
                        listaDet.add(detalleDeuda);
                    }
                } catch (WebApplicationException ex) {
                    if (ex.getResponse().getStatus() == 404) {
                        try {
                            Response productoResponse = inventarioRestClient.obtenerProductoCodigoBarras(d.getCodigoBarras(), obj.getIdNegocio());
                            if (productoResponse.getStatus() == 200) {
                                ProductoDTO productoDTO = productoResponse.readEntity(ProductoDTO.class);
                                productoDTO.setStockActual(productoDTO.getStockActual() - d.getCantidad());
                                inventarioRestClient.actualizarProducto(productoDTO.getCodigoBarras(), productoDTO);
                                DetalleDeuda detalleDeuda = new DetalleDeuda();
                                detalleDeuda.setCantidad(d.getCantidad());
                                detalleDeuda.setTotal(d.getSubtotal());
                                detalleDeuda.setProductoCodigo(d.getCodigoBarras());
                                detalleDeudaRepository.persist(detalleDeuda);
                                listaDet.add(detalleDeuda);
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

            deuda.setFecha(LocalDateTime.now());
            deuda.setTotal(obj.getTotal());
            deuda.setIdNegocio(obj.getIdNegocio());
            Integer numeroReferencia = generarNumeroDeuda(obj.getIdNegocio().longValue());
            deuda.setNumeroReferencia(numeroReferencia);

            this.deudaRepository.persist(deuda);

            for (DetalleDeuda detalleDeuda : listaDet) {
                detalleDeuda.setDeuda(deuda);
            }

            return Response.ok("Deuda generada con éxito").build();

        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al generar la deuda").build();
        }
    }

    public Response listaDeudas(Integer idNegocio) {
        try {
            List<Deuda> deudas = this.deudaRepository.find("idNegocio = ?1", idNegocio).list();

            if (deudas.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron deudas").build();
            }

            List<DeudaDTO> deudaDTOS = DeudaDTO.fromDeudasDTO(deudas);

            return Response.ok(deudaDTOS).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al obtener las deudas").build();
        }
    }

    public Response obtenerDeuda(Integer id) {
        try {
            Optional<Deuda> deudaOptional = this.deudaRepository.findByIdOptional(id);
            if (deudaOptional.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Deuda no encontrada").build();
            }
            DeudaDTO deudaDTO = DeudaDTO.from(deudaOptional.get());
            Cliente cliente = deudaOptional.get().getCliente();
            List<AbonoDTO> abonos = AbonoDTO.fromAbonoDTO(deudaOptional.get().getAbonos());
            deudaDTO.setAbonos(abonos);

            List<DetalleDeudaDTO> productos = new ArrayList<>();
            for (DetalleDeuda detalleDeuda : deudaOptional.get().getDetalles()) {
                if (detalleDeuda.getProductoCodigo() != null && !detalleDeuda.getProductoCodigo().isEmpty()) {

                    Response productoR = inventarioRestClient.obtenerProductoCodigoBarras(detalleDeuda.getProductoCodigo(), cliente.getIdNegocio());
                    ProductoDTO productoDTO = productoR.readEntity(ProductoDTO.class);

                    DetalleDeudaDTO detalleDeudaDTO = new DetalleDeudaDTO();
                    detalleDeudaDTO.setCantidad(detalleDeuda.getCantidad());
                    detalleDeudaDTO.setNombre(productoDTO.getNombre());
                    detalleDeudaDTO.setCodigoBarras(productoDTO.getCodigoBarras());
                    detalleDeudaDTO.setSubtotal(detalleDeuda.getTotal());
                    detalleDeudaDTO.setPrecioVenta(productoDTO.getPrecioVenta());

                    productos.add(detalleDeudaDTO);

                } else if (detalleDeuda.getSubProductoCodigo() != null && !detalleDeuda.getSubProductoCodigo().isEmpty()) {
                    Response subproductoR = inventarioRestClient.obtenerSubproductoCodigoBarras(detalleDeuda.getSubProductoCodigo(), cliente.getIdNegocio());
                    SubproductoDTO subproductoDTO = subproductoR.readEntity(SubproductoDTO.class);

                    DetalleDeudaDTO detalleDeudaDTO = new DetalleDeudaDTO();
                    detalleDeudaDTO.setCantidad(detalleDeuda.getCantidad());
                    detalleDeudaDTO.setNombre(subproductoDTO.getNombre());
                    detalleDeudaDTO.setCodigoBarras(subproductoDTO.getCodigoBarras());
                    detalleDeudaDTO.setSubtotal(detalleDeuda.getTotal());
                    detalleDeudaDTO.setPrecioVenta(subproductoDTO.getPrecioVenta());

                    productos.add(detalleDeudaDTO);
                }

                deudaDTO.setDetalles(productos);
            }

            return Response.ok(deudaDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al buscar el subproducto").build();
        }
    }

    public Response obtenerDeudaPorNumeroReferencia(Integer numeroReferencia, Integer idNegocio) {
        try {
            Optional<Deuda> deudaOptional = this.deudaRepository.find("numeroReferencia = ?1 AND idNegocio = ?2", numeroReferencia, idNegocio).firstResultOptional();
            if (deudaOptional.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Deuda no encontrada").build();
            }
            DeudaDTO deudaDTO = DeudaDTO.from(deudaOptional.get());
            Cliente cliente = deudaOptional.get().getCliente();
            List<AbonoDTO> abonos = AbonoDTO.fromAbonoDTO(deudaOptional.get().getAbonos());
            deudaDTO.setAbonos(abonos);

            List<DetalleDeudaDTO> productos = new ArrayList<>();
            for (DetalleDeuda detalleDeuda : deudaOptional.get().getDetalles()) {
                if (detalleDeuda.getProductoCodigo() != null && !detalleDeuda.getProductoCodigo().isEmpty()) {

                    Response productoR = inventarioRestClient.obtenerProductoCodigoBarras(detalleDeuda.getProductoCodigo(), cliente.getIdNegocio());
                    ProductoDTO productoDTO = productoR.readEntity(ProductoDTO.class);

                    DetalleDeudaDTO detalleDeudaDTO = new DetalleDeudaDTO();
                    detalleDeudaDTO.setCantidad(detalleDeuda.getCantidad());
                    detalleDeudaDTO.setNombre(productoDTO.getNombre());
                    detalleDeudaDTO.setCodigoBarras(productoDTO.getCodigoBarras());
                    detalleDeudaDTO.setSubtotal(detalleDeuda.getTotal());
                    detalleDeudaDTO.setPrecioVenta(productoDTO.getPrecioVenta());

                    productos.add(detalleDeudaDTO);

                } else if (detalleDeuda.getSubProductoCodigo() != null && !detalleDeuda.getSubProductoCodigo().isEmpty()) {
                    Response subproductoR = inventarioRestClient.obtenerSubproductoCodigoBarras(detalleDeuda.getSubProductoCodigo(), cliente.getIdNegocio());
                    SubproductoDTO subproductoDTO = subproductoR.readEntity(SubproductoDTO.class);

                    DetalleDeudaDTO detalleDeudaDTO = new DetalleDeudaDTO();
                    detalleDeudaDTO.setCantidad(detalleDeuda.getCantidad());
                    detalleDeudaDTO.setNombre(subproductoDTO.getNombre());
                    detalleDeudaDTO.setCodigoBarras(subproductoDTO.getCodigoBarras());
                    detalleDeudaDTO.setSubtotal(detalleDeuda.getTotal());
                    detalleDeudaDTO.setPrecioVenta(subproductoDTO.getPrecioVenta());

                    productos.add(detalleDeudaDTO);
                }

                deudaDTO.setDetalles(productos);
            }

            return Response.ok(deudaDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al buscar la deuda").build();
        }
    }

    @Transactional
    public Response registrarAbono(AbonoDTO abonoDTO) {
        try {
            Optional<Deuda> deudaOptional = this.deudaRepository.findByIdOptional(abonoDTO.getIdDeuda());
            if (deudaOptional.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Deuda no encontrada").build();
            }

            Deuda deuda = deudaOptional.get();
            BigDecimal nuevoTotal = deuda.getTotal().subtract(abonoDTO.getMonto());
            deuda.setTotal(nuevoTotal);

            if (nuevoTotal.compareTo(BigDecimal.ZERO) == 0) {
                deuda.setEstado(false);
            }

            Abono abono = new Abono();
            abono.setMonto(abonoDTO.getMonto());
            abono.setFecha(LocalDateTime.now());
            abono.setDeuda(deuda);
            abono.setIdCuadreCaja(abonoDTO.getIdCuadreCaja());
            abono.setPagoTransferencia(abonoDTO.getPagoTransferencia());

            this.abonoRepository.persist(abono);

            return Response.ok("Abono registrado exitosamente").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al registrar el abono").build();
        }
    }

    public Response obtenerAbonosPorCuadreCaja(Long idCuadreCaja) {
        try {
            List<Abono> abonos = abonoRepository.find("idCuadreCaja = ?1", idCuadreCaja).list();

            if (abonos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron abonos para el cuadre de caja: " + idCuadreCaja).build();
            }

            List<AbonoDTO> abonosDTO = AbonoDTO.fromAbonoDTO(abonos);

            return Response.ok(abonosDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al obtener los abonos").build();
        }
    }

}