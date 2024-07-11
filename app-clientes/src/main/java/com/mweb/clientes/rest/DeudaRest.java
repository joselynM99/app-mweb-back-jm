package com.mweb.clientes.rest;

import com.mweb.clientes.client.InventarioRestClient;
import com.mweb.clientes.db.DetalleDeuda;
import com.mweb.clientes.db.Deuda;
import com.mweb.clientes.dtos.*;
import com.mweb.clientes.repo.ClienteRepository;
import com.mweb.clientes.repo.DetalleDeudaRepository;
import com.mweb.clientes.repo.DeudaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/clientes/deudas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class DeudaRest {

    @Inject
    @RestClient
    InventarioRestClient inventarioRestClient;
    @Inject
    ClienteRepository clienteRepository;
    @Inject
    DeudaRepository deudaRepository;
    @Inject
    DetalleDeudaRepository detalleDeudaRepository;

    @POST
    public Response generarDeuda(DeudaDTO obj) {
        try {
            Deuda deuda = new Deuda();
            deuda.setEstado(true);
            deuda.setCliente(this.clienteRepository.find("identificacion = ?1 AND activo =?2", obj.getClienteId(), true).singleResult());

            List<DetalleDeuda> listaDet = new ArrayList<>();

            for (ProductoCarritoDTO d : obj.getDetalles()) {
                Response subproductoResponse = inventarioRestClient.obtenerSubproductoCodigoBarras(d.getCodigoBarras());
                Response productoResponse = inventarioRestClient.obtenerProductoCodigoBarras(d.getCodigoBarras());

                if (subproductoResponse.getStatus() == 200) {
                    SubproductoDTO subproductoDTO = subproductoResponse.readEntity(SubproductoDTO.class);
                    subproductoDTO.setStockActual(subproductoDTO.getStockActual() - d.getCantidad());
                    inventarioRestClient.actualizarSubproducto(subproductoDTO.getCodigoBarras(), subproductoDTO);

                    Response productoSR = inventarioRestClient.obtenerProductoCodigoBarras(subproductoDTO.getProducto());
                    ProductoDTO productoDTOS = productoSR.readEntity(ProductoDTO.class);
                    productoDTOS.setStockActual(subproductoDTO.getStockActual() / subproductoDTO.getCantidadRelacionada());
                    inventarioRestClient.actualizarProducto(productoDTOS.getCodigoBarras(), productoDTOS);

                    DetalleDeuda detalleDeuda = new DetalleDeuda();
                    detalleDeuda.setCantidad(d.getCantidad());
                    detalleDeuda.setTotal(d.getSubtotal());
                    detalleDeuda.setSubProductoCodigo(d.getCodigoBarras());
                    detalleDeudaRepository.persist(detalleDeuda);
                    listaDet.add(detalleDeuda);
                } else {
                    ProductoDTO productoDTO = productoResponse.readEntity(ProductoDTO.class);
                    productoDTO.setStockActual(productoDTO.getStockActual() - d.getCantidad());
                    inventarioRestClient.actualizarProducto(productoDTO.getCodigoBarras(), productoDTO);

                    Response subproductosR = inventarioRestClient.listaSubproductosPorProducto(productoDTO.getCodigoBarras());

                    if (subproductosR.getStatus() == 200) {
                        List<SubproductoDTO> subproductos = subproductosR.readEntity(new GenericType<List<SubproductoDTO>>() {
                        });

                        for (SubproductoDTO sub : subproductos) {
                            sub.setStockActual(sub.getStockActual() - (sub.getCantidadRelacionada() * d.getCantidad()));
                            inventarioRestClient.actualizarSubproducto(sub.getCodigoBarras(), sub);
                        }
                    }

                    DetalleDeuda detalleDeuda = new DetalleDeuda();
                    detalleDeuda.setCantidad(d.getCantidad());
                    detalleDeuda.setTotal(d.getSubtotal());
                    detalleDeuda.setProductoCodigo(d.getCodigoBarras());
                    detalleDeudaRepository.persist(detalleDeuda);
                    listaDet.add(detalleDeuda);

                }
            }

            deuda.setDetalles(listaDet);
            deuda.setFecha(LocalDateTime.now());
            deuda.setTotal(obj.getTotal());
            this.deudaRepository.persist(deuda);

            return Response.ok(deuda).build();

//            for (DetalleDeuda detalleDeuda: listaDet){
//                detalleDeuda.setDeuda(deuda);
//            }

        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al generar la deuda").build();
        }
    }

    @GET
    public Response listaDeudas() {
        try {
            List<Deuda> deudas = this.deudaRepository.findAll().list();

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

    @GET
    @Path("/{id}")
    public Response obteneDeuda(@PathParam("id") Integer id) {
        try {
            Optional<Deuda> deudaOptional = this.deudaRepository.findByIdOptional(id);
            if (deudaOptional.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Deuda no encontrada").build();
            }
            DeudaDTO deudaDTO = DeudaDTO.from(deudaOptional.get());

            List<AbonoDTO> abonos = AbonoDTO.fromAbonoDTO(deudaOptional.get().getAbonos());
            deudaDTO.setAbonos(abonos);

            List<ProductoCarritoDTO> productos = new ArrayList<>();

            for (DetalleDeuda detalleDeuda : deudaOptional.get().getDetalles()) {
                if (detalleDeuda.getProductoCodigo() != null && !detalleDeuda.getProductoCodigo().isEmpty()) {

                    Response productoR = inventarioRestClient.obtenerProductoCodigoBarras(detalleDeuda.getProductoCodigo());
                    ProductoDTO productoDTO = productoR.readEntity(ProductoDTO.class);

                    ProductoCarritoDTO productoCarritoDTO = new ProductoCarritoDTO();
                    productoCarritoDTO.setCantidad(detalleDeuda.getCantidad());
                    productoCarritoDTO.setNombre(productoDTO.getNombre());
                    productoCarritoDTO.setCodigoBarras(productoDTO.getCodigoBarras());
                    productoCarritoDTO.setSubtotal(detalleDeuda.getTotal());
                    productoCarritoDTO.setPrecioVenta(productoDTO.getPrecioVenta());
                    productoCarritoDTO.setCostoPromedio(productoDTO.getCostoPromedio());
                    productoCarritoDTO.setPrecioSinImpuestos(productoDTO.getPrecioSinImpuestos());

                    productos.add(productoCarritoDTO);

                } else if (detalleDeuda.getSubProductoCodigo() != null && !detalleDeuda.getSubProductoCodigo().isEmpty()) {
                    Response subproductoR = inventarioRestClient.obtenerSubproductoCodigoBarras(detalleDeuda.getSubProductoCodigo());
                    SubproductoDTO subproductoDTO = subproductoR.readEntity(SubproductoDTO.class);

                    ProductoCarritoDTO productoCarritoDTO = new ProductoCarritoDTO();
                    productoCarritoDTO.setCantidad(detalleDeuda.getCantidad());
                    productoCarritoDTO.setNombre(subproductoDTO.getNombre());
                    productoCarritoDTO.setCodigoBarras(subproductoDTO.getCodigoBarras());
                    productoCarritoDTO.setSubtotal(detalleDeuda.getTotal());
                    productoCarritoDTO.setPrecioVenta(subproductoDTO.getPrecioVenta());
                    productoCarritoDTO.setCostoPromedio(subproductoDTO.getCostoPromedio());
                    productoCarritoDTO.setPrecioSinImpuestos(subproductoDTO.getPrecioSinImpuestos());

                    productos.add(productoCarritoDTO);
                }

                deudaDTO.setDetalles(productos);
            }

            return Response.ok(deudaDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al buscar el subproducto").build();
        }
    }


    //******Pendiente hasta modulo de cajas y de empleados**********
//    @POST
//    @Path("/abonos")
//    public Response registrarAbono(){
//
//    }


}
