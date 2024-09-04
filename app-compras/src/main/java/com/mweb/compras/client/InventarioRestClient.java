package com.mweb.compras.client;


import com.mweb.compras.dtos.ProductoDTO;
import com.mweb.compras.dtos.SubproductoDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/inventario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "InventarioRestClient")
public interface InventarioRestClient {



    @PUT
    @Path("/productos/{codigoBarras}")
    Response actualizarProducto(@PathParam("codigoBarras") String codigoBarras, ProductoDTO obj);

    @PUT
    @Path("/subproductos/{codigoBarras}")
    Response actualizarSubproducto(@PathParam("codigoBarras") String codigoBarras, SubproductoDTO obj);

    @GET
    @Path("/productos/{codigoBarras}/proveedor/{proveedorId}")
    Response obtenerProductoPorCodigoBarrasYProveedor(@PathParam("codigoBarras") String codigoBarras, @PathParam("proveedorId") String proveedorId, @QueryParam("idNegocio") Integer idNegocio);


    @GET
    @Path("/subproductos/buscar-por-producto/{codigo}/proveedor/{proveedorId}")
    Response listaSubproductosPorProductoYProveedor(@PathParam("codigo") String codigo, @PathParam("proveedorId") String proveedorId, @QueryParam("idNegocio") Integer idNegocio);
}
