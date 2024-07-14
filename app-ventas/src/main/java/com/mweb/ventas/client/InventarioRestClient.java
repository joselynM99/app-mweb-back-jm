package com.mweb.ventas.client;


import com.mweb.ventas.dtos.ProductoDTO;
import com.mweb.ventas.dtos.SubproductoDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/inventario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "InventarioRestClient")
public interface InventarioRestClient {
    @GET
    @Path("/productos")
    Response listaProductos();

    @GET
    @Path("/subproductos")
    Response listaSubproductos();
    @GET
    @Path("/subproductos/buscar-por-nombre/{nombre}")
    Response listaSubproductosPorNombre(@PathParam("nombre") String nombre);

    @GET
    @Path("/productos/buscar-por-nombre/{nombre}")
    Response listaProductosPorNombre(@PathParam("nombre") String nombre);

    @GET
    @Path("/subproductos/{codigoBarras}")
    Response obtenerSubproductoCodigoBarras(@PathParam("codigoBarras") String codigoBarras);

    @GET
    @Path("/productos/{codigoBarras}")
    Response obtenerProductoCodigoBarras(@PathParam("codigoBarras") String codigoBarras);

    @PUT
    @Path("/productos/{codigoBarras}")
    Response actualizarProducto(@PathParam("codigoBarras") String codigoBarras, ProductoDTO obj);

    @PUT
    @Path("/subproductos/{codigoBarras}")
    Response actualizarSubproducto(@PathParam("codigoBarras") String codigoBarras, SubproductoDTO obj);

    @GET
    @Path("/subproductos/buscar-por-producto/{codigo}")
    Response listaSubproductosPorProducto(@PathParam("codigo") String codigo);

}
