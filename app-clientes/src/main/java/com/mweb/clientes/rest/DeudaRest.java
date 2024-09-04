package com.mweb.clientes.rest;

import com.mweb.clientes.dtos.*;
import com.mweb.clientes.service.DeudaService;
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
    @PermitAll
    public Response generarDeuda(DeudaDTO obj) {
        return deudaService.generarDeuda(obj);
    }

    @GET
    @PermitAll
    public Response listaDeudas(@QueryParam("idNegocio") Integer idNegocio) {
        return deudaService.listaDeudas(idNegocio);
    }

    @GET
    @Path("/{id}")
    @PermitAll
    public Response obtenerDeuda(@PathParam("id") Integer id) {
        return deudaService.obtenerDeuda(id);
    }

    @GET
    @Path("/buscar-por-referencia")
    @PermitAll
    public Response obtenerDeudaPorNumeroReferencia(@QueryParam("numeroReferencia") Integer numeroReferencia, @QueryParam("idNegocio") Integer idNegocio) {
        return deudaService.obtenerDeudaPorNumeroReferencia(numeroReferencia, idNegocio);
    }

    @POST
    @Path("/abonos")
    @PermitAll
    public Response registrarAbono(AbonoDTO abonoDTO) {
        return deudaService.registrarAbono(abonoDTO);
    }
}