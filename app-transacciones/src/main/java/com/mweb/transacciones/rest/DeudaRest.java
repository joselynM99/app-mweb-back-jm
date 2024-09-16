package com.mweb.transacciones.rest;

import com.mweb.transacciones.dtos.*;
import com.mweb.transacciones.service.DeudaService;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clientes/deudas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeudaRest {

    @Inject
    DeudaService deudaService;

    @POST
    @Authenticated
    public Response generarDeuda(DeudaDTO obj) {
        return deudaService.generarDeuda(obj);
    }

    @GET
    @Authenticated
    public Response listaDeudas(@QueryParam("idNegocio") Integer idNegocio) {
        return deudaService.listaDeudas(idNegocio);
    }

    @GET
    @Path("/{id}")
    @Authenticated
    public Response obtenerDeuda(@PathParam("id") Integer id) {
        return deudaService.obtenerDeuda(id);
    }

    @GET
    @Path("/buscar-por-referencia")
    @Authenticated
    public Response obtenerDeudaPorNumeroReferencia(@QueryParam("numeroReferencia") Integer numeroReferencia, @QueryParam("idNegocio") Integer idNegocio) {
        return deudaService.obtenerDeudaPorNumeroReferencia(numeroReferencia, idNegocio);
    }

    @POST
    @Path("/abonos")
    @Authenticated
    public Response registrarAbono(AbonoDTO abonoDTO) {
        return deudaService.registrarAbono(abonoDTO);
    }
}