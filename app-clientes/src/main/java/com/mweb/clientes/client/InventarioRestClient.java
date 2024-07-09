package com.mweb.clientes.client;

import com.mweb.clientes.dtos.ProductoDTO;
import com.mweb.clientes.dtos.SubproductoDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/inventario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "InventarioRestClient")
public interface InventarioRestClient {

    @Path("/subproductos/{codigoBarras}")
    public SubproductoDTO obtenerSubproductoCodigoBarras(@PathParam("codigoBarras") String codigoBarras);
    @GET
    @Path("/productos/{codigoBarras}")
    public ProductoDTO obtenerProductoCodigoBarras(@PathParam("codigoBarras") String codigoBarras);


}
