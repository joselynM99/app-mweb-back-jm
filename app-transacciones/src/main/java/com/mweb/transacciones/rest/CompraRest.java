package com.mweb.transacciones.rest;

import com.mweb.transacciones.dtos.CompraRequestDTO;
import com.mweb.transacciones.dtos.CompraResumenDTO;
import com.mweb.transacciones.service.CompraService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.List;

@Path("/compras")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompraRest {

    @Inject
    CompraService compraService;


    @POST
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response registrarCompras(CompraRequestDTO obj) {
        return compraService.registrarCompras(obj);
    }


    @GET
    @Path("/cuadre-caja/{idCuadreCaja}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response obtenerComprasPorCuadreCaja(@PathParam("idCuadreCaja") Integer idCuadreCaja) {
        try {
            List<CompraResumenDTO> compras = compraService.obtenerComprasPorCuadreCaja(idCuadreCaja);
            return Response.ok(compras).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al buscar las compras").build();
        }
    }

    @GET
    @Path("/detalle/{numeroReferencia}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response obtenerCompraPorNumeroReferenciaYNegocio(@PathParam("numeroReferencia") Integer numeroReferencia, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            CompraRequestDTO compra = compraService.obtenerCompraPorNumeroReferenciaYNegocio(numeroReferencia, idNegocio);
            return Response.ok(compra).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al buscar la compra").build();
        }
    }

    @GET
    @Path("/buscar")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response buscarCompras(@QueryParam("numeroReferencia") Integer numeroReferencia,
                                  @QueryParam("fechaInicio") String fechaInicioStr,
                                  @QueryParam("fechaFin") String fechaFinStr,
                                  @QueryParam("username") String username,
                                  @QueryParam("idNegocio") Integer idNegocio) {
        try {
            LocalDateTime fechaInicio = fechaInicioStr != null ? LocalDateTime.parse(fechaInicioStr) : null;
            LocalDateTime fechaFin = fechaFinStr != null ? LocalDateTime.parse(fechaFinStr) : null;
            List<CompraResumenDTO> compras = compraService.buscarCompras(numeroReferencia, fechaInicio, fechaFin, username, idNegocio);
            return Response.ok(compras).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al buscar las compras").build();
        }
    }

}