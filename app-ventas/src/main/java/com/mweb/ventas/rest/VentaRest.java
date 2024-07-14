package com.mweb.ventas.rest;

import com.mweb.ventas.client.ClientesRestClient;
import com.mweb.ventas.client.InventarioRestClient;
import com.mweb.ventas.db.DetalleVenta;
import com.mweb.ventas.db.Venta;
import com.mweb.ventas.dtos.*;
import com.mweb.ventas.repo.DetalleVentaRepository;
import com.mweb.ventas.repo.VentaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Path("/ventas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class VentaRest {

    @Inject
    @RestClient
    InventarioRestClient inventarioRestClient;

    @Inject
    @RestClient
    ClientesRestClient clientesRestClient;

    @Inject
    VentaRepository ventaRepository;

    @Inject
    DetalleVentaRepository detalleVentaRepository;

    @GET
    @Path("/productos")
    public Response listaProductosVenta() {
        try {
            List<ProductoVentaDTO> productoVentaDTOS = new ArrayList<>();
            boolean encontradoAlguno = false;
            try {
                Response subproductosResponse = inventarioRestClient.listaSubproductos();
                if (subproductosResponse.getStatus() == 200) {
                    List<SubproductoDTO> subproductosDTO = subproductosResponse.readEntity(new GenericType<List<SubproductoDTO>>() {
                    });
                    for (SubproductoDTO subproductoDTO : subproductosDTO) {
                        ProductoVentaDTO productoVentaDTO = new ProductoVentaDTO();
                        productoVentaDTO.setPrecioVenta(subproductoDTO.getPrecioVenta());
                        productoVentaDTO.setNombre(subproductoDTO.getNombre());
                        productoVentaDTO.setCodigoBarras(subproductoDTO.getCodigoBarras());

                        productoVentaDTOS.add(productoVentaDTO);
                    }
                    encontradoAlguno = true;
                }

            } catch (WebApplicationException e) {
                if (e.getResponse().getStatus() != 404) {
                    throw e; // Re-lanzar si no es un 404
                }
                // Si es 404, simplemente continuamos con la búsqueda de productos
            }

            try {
                Response productosResponse = inventarioRestClient.listaProductos();
                if (productosResponse.getStatus() == 200) {
                    List<ProductoDTO> productosDTO = productosResponse.readEntity(new GenericType<List<ProductoDTO>>() {
                    });
                    for (ProductoDTO productoDTO : productosDTO) {
                        ProductoVentaDTO productoVentaDTO = new ProductoVentaDTO();
                        productoVentaDTO.setPrecioVenta(productoDTO.getPrecioVenta());
                        productoVentaDTO.setNombre(productoDTO.getNombre());
                        productoVentaDTO.setCodigoBarras(productoDTO.getCodigoBarras());

                        productoVentaDTOS.add(productoVentaDTO);
                    }
                    encontradoAlguno = true;
                }
            } catch (WebApplicationException e) {
                if (e.getResponse().getStatus() != 404) {
                    throw e; // Re-lanzar si no es un 404
                }
                // Si es 404, simplemente continuamos
            }

            if (!encontradoAlguno) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron productos ni subproductos").build();
            }

            return Response.ok(productoVentaDTOS).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al buscar los productos").build();
        }

    }

    @GET
    @Path("/productos/buscar-por-nombre/{nombre}")
    public Response listaProductosVentaPorNombre(@PathParam("nombre") String nombre) {
        try {
            List<ProductoVentaDTO> productoVentaDTOS = new ArrayList<>();
            boolean encontradoAlguno = false;

            // Buscar subproductos
            try {
                Response subproductosResponse = inventarioRestClient.listaSubproductosPorNombre(nombre);
                if (subproductosResponse.getStatus() == 200) {
                    List<SubproductoDTO> subproductosDTO = subproductosResponse.readEntity(new GenericType<List<SubproductoDTO>>() {
                    });
                    for (SubproductoDTO subproductoDTO : subproductosDTO) {
                        ProductoVentaDTO productoVentaDTO = new ProductoVentaDTO();
                        productoVentaDTO.setPrecioVenta(subproductoDTO.getPrecioVenta());
                        productoVentaDTO.setNombre(subproductoDTO.getNombre());
                        productoVentaDTO.setCodigoBarras(subproductoDTO.getCodigoBarras());
                        productoVentaDTOS.add(productoVentaDTO);
                    }
                    encontradoAlguno = true;
                }
            } catch (WebApplicationException e) {
                if (e.getResponse().getStatus() != 404) {
                    throw e; // Re-lanzar si no es un 404
                }
                // Si es 404, simplemente continuamos con la búsqueda de productos
            }

            // Buscar productos
            try {
                Response productosResponse = inventarioRestClient.listaProductosPorNombre(nombre);
                if (productosResponse.getStatus() == 200) {
                    List<ProductoDTO> productosDTO = productosResponse.readEntity(new GenericType<List<ProductoDTO>>() {
                    });
                    for (ProductoDTO productoDTO : productosDTO) {
                        ProductoVentaDTO productoVentaDTO = new ProductoVentaDTO();
                        productoVentaDTO.setPrecioVenta(productoDTO.getPrecioVenta());
                        productoVentaDTO.setNombre(productoDTO.getNombre());
                        productoVentaDTO.setCodigoBarras(productoDTO.getCodigoBarras());
                        productoVentaDTOS.add(productoVentaDTO);
                    }
                    encontradoAlguno = true;
                }
            } catch (WebApplicationException e) {
                if (e.getResponse().getStatus() != 404) {
                    throw e; // Re-lanzar si no es un 404
                }
                // Si es 404, simplemente continuamos
            }

            if (!encontradoAlguno) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron productos ni subproductos con el nombre: " + nombre).build();
            }

            return Response.ok(productoVentaDTOS).build();

        } catch (WebApplicationException e) {
            // Manejar otros errores de la aplicación web
            return Response.status(e.getResponse().getStatus()).entity("Error al buscar productos: " + e.getMessage()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al buscar los productos").build();
        }
    }

    @GET
    @Path("/productos/{codigoBarras}")
    public Response agregarProductosCarrito(@PathParam("codigoBarras") String codigoBarras) {
        try {
            try {
                Response subproductoResponse = inventarioRestClient.obtenerSubproductoCodigoBarras(codigoBarras);
                if (subproductoResponse.getStatus() == 200) {
                    SubproductoDTO subproductoDTO = subproductoResponse.readEntity(SubproductoDTO.class);
                    ProductoCarritoDTO productoCarritoDTO = ProductoCarritoDTO.from(subproductoDTO);
                    return Response.ok(productoCarritoDTO).build();
                }
            } catch (WebApplicationException e) {
                if (e.getResponse().getStatus() != 404) {
                    throw e;
                }
            }

            try {
                Response productoResponse = inventarioRestClient.obtenerProductoCodigoBarras(codigoBarras);
                if (productoResponse.getStatus() == 200) {
                    ProductoDTO productoDTO = productoResponse.readEntity(ProductoDTO.class);
                    ProductoCarritoDTO productoCarritoDTO = ProductoCarritoDTO.from(productoDTO);
                    return Response.ok(productoCarritoDTO).build();
                }
            } catch (WebApplicationException e) {
                if (e.getResponse().getStatus() != 404) {
                    throw e; // Re-lanzar si no es un 404
                }
            }

            return Response.status(Response.Status.NOT_FOUND).entity("No se encontró ningún producto o subproducto con el código de barras: " + codigoBarras).build();

        } catch (WebApplicationException e) {
            return Response.status(e.getResponse().getStatus()).entity("Error al buscar el producto: " + e.getMessage()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al buscar el producto").build();
        }
    }

    @POST
    @Transactional
    public Response registrarVentas(VentaRequestDTO obj) {
        try {
            Venta venta = new Venta();
            venta.setClienteIdentificacion(obj.getCliente());
            List<DetalleVenta> listaDet = new ArrayList<>();

            for (ProductoCarritoDTO d : obj.getDetalles()) {
                try {
                    Response subproductoResponse = inventarioRestClient.obtenerSubproductoCodigoBarras(d.getCodigoBarras());
                    if (subproductoResponse.getStatus() == 200) {
                        SubproductoDTO subproductoDTO = subproductoResponse.readEntity(SubproductoDTO.class);
                        subproductoDTO.setStockActual(subproductoDTO.getStockActual() - d.getCantidad());
                        inventarioRestClient.actualizarSubproducto(subproductoDTO.getCodigoBarras(), subproductoDTO);

                        Response productoSR = inventarioRestClient.obtenerProductoCodigoBarras(subproductoDTO.getProducto());
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
                } catch (jakarta.ws.rs.WebApplicationException ex) {
                    if (ex.getResponse().getStatus() == 404) {
                        try {
                            Response productoResponse = inventarioRestClient.obtenerProductoCodigoBarras(d.getCodigoBarras());
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
                                    Response subproductosR = inventarioRestClient.listaSubproductosPorProducto(productoDTO.getCodigoBarras());
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
                        } catch (jakarta.ws.rs.WebApplicationException e) {
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
            this.ventaRepository.persist(venta);

            for (DetalleVenta detalleVenta : listaDet) {
                detalleVenta.setVenta(venta);
            }

            return Response.ok("Venta generada con éxito").build();

        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al generar la venta").build();
        }
    }


}
