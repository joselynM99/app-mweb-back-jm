package com.mweb.ventas.rest;

import com.mweb.ventas.dtos.VentaRequestDTO;
import com.mweb.ventas.dtos.VentaResumenDTO;
import com.mweb.ventas.service.VentaService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.List;

@Path("/ventas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VentaRest {

    @Inject
    VentaService ventaService;


    @POST
    @Transactional
    @PermitAll
    public Response registrarVentas(VentaRequestDTO obj) {
        return ventaService.registrarVentas(obj);
    }

    @GET
    @Path("/cuadre-caja/{idCuadreCaja}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response obtenerVentasPorCuadreCaja(@PathParam("idCuadreCaja") Integer idCuadreCaja) {
        try {
            List<VentaResumenDTO> ventas = ventaService.obtenerVentasPorCuadreCaja(idCuadreCaja);
            return Response.ok(ventas).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al buscar las ventas").build();
        }
    }

    @GET
    @Path("/detalle/{numeroReferencia}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response obtenerVentaPorNumeroReferenciaYNegocio(@PathParam("numeroReferencia") Integer numeroReferencia, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            VentaRequestDTO venta = ventaService.obtenerVentaPorNumeroReferenciaYNegocio(numeroReferencia, idNegocio);
            return Response.ok(venta).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al buscar la venta").build();
        }
    }

    @GET
    @Path("/buscar")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response buscarVentas(@QueryParam("numeroReferencia") Integer numeroReferencia,
                                 @QueryParam("fechaInicio") String fechaInicioStr,
                                 @QueryParam("fechaFin") String fechaFinStr,
                                 @QueryParam("username") String username,
                                 @QueryParam("idNegocio") Integer idNegocio) {
        try {
            LocalDateTime fechaInicio = fechaInicioStr != null ? LocalDateTime.parse(fechaInicioStr) : null;
            LocalDateTime fechaFin = fechaFinStr != null ? LocalDateTime.parse(fechaFinStr) : null;
            List<VentaResumenDTO> ventas = ventaService.buscarVentas(numeroReferencia, fechaInicio, fechaFin, username, idNegocio);
            return Response.ok(ventas).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ha ocurrido un error al buscar las ventas").build();
        }
    }
}