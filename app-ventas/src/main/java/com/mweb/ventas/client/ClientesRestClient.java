package com.mweb.ventas.client;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "ClientesRestClient")
public interface ClientesRestClient {

    @GET
    @Path("/{identificacion}")
    Response obtenerClientePorIdentificacion(@PathParam("identificacion") String identificacion);

}
