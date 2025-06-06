package com.mweb.transacciones.client;

import com.mweb.transacciones.dtos.ProductoDTO;
import com.mweb.transacciones.dtos.SubproductoDTO;
import io.quarkus.oidc.client.reactive.filter.OidcClientRequestReactiveFilter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/inventario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "InventarioRestClient")
@RegisterProvider(OidcClientRequestReactiveFilter.class)
public interface InventarioRestClient {
    @GET
    @Path("/subproductos/{codigoBarras}")
    Response obtenerSubproductoCodigoBarras(@PathParam("codigoBarras") String codigoBarras, @QueryParam("idNegocio") Integer idNegocio);

    @GET
    @Path("/productos/{codigoBarras}")
    Response obtenerProductoCodigoBarras(@PathParam("codigoBarras") String codigoBarras, @QueryParam("idNegocio") Integer idNegocio);

    @PUT
    @Path("/productos/{codigoBarras}")
    Response actualizarProducto(@PathParam("codigoBarras") String codigoBarras, ProductoDTO obj);

    @PUT
    @Path("/subproductos/{codigoBarras}")
    Response actualizarSubproducto(@PathParam("codigoBarras") String codigoBarras, SubproductoDTO obj);

    @GET
    @Path("/subproductos/buscar-por-producto/{codigo}")
    Response listaSubproductosPorProducto(@PathParam("codigo") String codigo, @QueryParam("idNegocio") Integer idNegocio);

    @GET
    @Path("/productos/{codigoBarras}/proveedor/{proveedorId}")
    Response obtenerProductoPorCodigoBarrasYProveedor(@PathParam("codigoBarras") String codigoBarras, @PathParam("proveedorId") String proveedorId, @QueryParam("idNegocio") Integer idNegocio);

    @GET
    @Path("/subproductos/buscar-por-producto/{codigo}/proveedor/{proveedorId}")
    Response listaSubproductosPorProductoYProveedor(@PathParam("codigo") String codigo, @PathParam("proveedorId") String proveedorId, @QueryParam("idNegocio") Integer idNegocio);
}