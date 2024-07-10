package com.mweb.clientes.rest;

import com.mweb.clientes.client.InventarioRestClient;
import com.mweb.clientes.db.DetalleDeuda;
import com.mweb.clientes.db.Deuda;
import com.mweb.clientes.dtos.DeudaGeneradaDTO;
import com.mweb.clientes.dtos.ProductoCarritoDTO;
import com.mweb.clientes.dtos.ProductoDTO;
import com.mweb.clientes.dtos.SubproductoDTO;
import com.mweb.clientes.repo.ClienteRepository;
import com.mweb.clientes.repo.DetalleDeudaRepository;
import com.mweb.clientes.repo.DeudaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Path("/clientes/deudas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class DeudaRest {

    @Inject
    private ClienteRepository clienteRepository;

    @Inject
    private DeudaRepository deudaRepository;

    @Inject
    private DetalleDeudaRepository detalleDeudaRepository;

    @Inject
    @RestClient
    InventarioRestClient inventarioRestClient;

    @POST
    public Response generarDeuda(DeudaGeneradaDTO obj) {
        try {
            Deuda deuda = new Deuda();
            deuda.setEstado(true);
            deuda.setCliente(this.clienteRepository.find("identificacion = ?1 AND activo =?2", obj.getCliente(), true).singleResult());

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

                    Response subproductosR = inventarioRestClient.obtenerSubproductoCodigoBarras(productoDTO.getCodigoBarras());

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

//            for (DetalleDeuda detalleDeuda: listaDet){
//                detalleDeuda.setDeuda(deuda);
//            }

        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al generar la deuda")
                    .build();
        }
    }
}
