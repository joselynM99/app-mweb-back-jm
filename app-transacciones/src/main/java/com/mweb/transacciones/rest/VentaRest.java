package com.mweb.transacciones.rest;

import com.mweb.transacciones.dtos.ProductoMasVendidoDTO;
import com.mweb.transacciones.dtos.VentaRequestDTO;
import com.mweb.transacciones.dtos.VentaResumenDTO;
import com.mweb.transacciones.service.VentaService;
import io.quarkus.security.Authenticated;
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
    @Authenticated
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

    @GET
    @Path("/mas-vendidos")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response obtenerProductosMasVendidos(@QueryParam("fechaInicio") String fechaInicioStr,
                                                @QueryParam("fechaFin") String fechaFinStr,
                                                @QueryParam("idNegocio") Integer idNegocio,
                                                @QueryParam("limite") @DefaultValue("10") int limite) {
        try {
            LocalDateTime fechaInicio = fechaInicioStr != null ? LocalDateTime.parse(fechaInicioStr) : null;
            LocalDateTime fechaFin = fechaFinStr != null ? LocalDateTime.parse(fechaFinStr) : null;

            List<ProductoMasVendidoDTO> productos = ventaService.obtenerProductosMasVendidos(fechaInicio, fechaFin, idNegocio, limite);
            return Response.ok(productos).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al obtener productos más vendidos").build();
        }
    }

}