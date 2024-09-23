package com.mweb.gestion.cajas.rest;

import com.mweb.gestion.cajas.dtos.AdicionalesDTO;
import com.mweb.gestion.cajas.dtos.CajaDTO;
import com.mweb.gestion.cajas.dtos.CuadreCajaDTO;
import com.mweb.gestion.cajas.service.CuadreCajaService;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.List;

@Path("/gestion-cajas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CuadreCajaRest {

    @Inject
    CuadreCajaService cuadreCajaService;

    @POST
    @Path("/caja")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response crearCaja(CajaDTO cajaDTO) {
        System.out.println("Creando caja: " + cajaDTO.toString());
        try {
            CajaDTO createdCaja = cuadreCajaService.crearCaja(cajaDTO);
            return Response.ok(createdCaja).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al crear la caja").build();
        }
    }

    @GET
    @Path("/cajas-activas/{idNegocio}")
    @Authenticated
    public Response obtenerCajasActivasPorNegocio(@PathParam("idNegocio") Integer idNegocio) {
        try {
            List<CajaDTO> cajas = cuadreCajaService.obtenerCajasActivasPorNegocio(idNegocio);
            return Response.ok(cajas).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al obtener las cajas activas").build();
        }
    }

    @PATCH
    @Path("/caja/desactivar/{idCaja}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response desactivarCaja(@PathParam("idCaja") Integer idCaja) {
        try {
            cuadreCajaService.desactivarCaja(idCaja);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al desactivar la caja").build();
        }
    }

    @PUT
    @Path("/caja")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response actualizarCaja(CajaDTO cajaDTO) {
        try {
            CajaDTO updatedCaja = cuadreCajaService.actualizarCaja(cajaDTO);
            return Response.ok(updatedCaja).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al actualizar la caja").build();
        }
    }

    @POST
    @Path("/adicional")
    @Authenticated
    public Response registrarAdicional(AdicionalesDTO adicionalesDTO) {
        try {
            AdicionalesDTO createdAdicional = cuadreCajaService.registrarAdicional(adicionalesDTO);
            return Response.ok(createdAdicional).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al registrar el adicional").build();
        }
    }

    @GET
    @Path("/adicionales-activos/{idCuadreCaja}")
    @Authenticated
    public Response obtenerAdicionalesActivosPorCuadreCaja(@PathParam("idCuadreCaja") Integer idCuadreCaja) {
        try {
            List<AdicionalesDTO> adicionales = cuadreCajaService.obtenerAdicionalesActivosPorCuadreCaja(idCuadreCaja);
            return Response.ok(adicionales).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al obtener los adicionales activos").build();
        }
    }

    @PATCH
    @Path("/adicional/desactivar/{idAdicional}")
    @Authenticated
    public Response desactivarAdicional(@PathParam("idAdicional") Integer idAdicional) {
        try {
            cuadreCajaService.desactivarAdicional(idAdicional);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al desactivar el adicional").build();
        }
    }

    @POST
    @Path("/abrir")
    @Authenticated
    public Response abrirCaja(CuadreCajaDTO cuadreCajaDTO) {
        try {
            CuadreCajaDTO createdCuadreCaja = cuadreCajaService.abrirCaja(cuadreCajaDTO);
            return Response.ok(createdCuadreCaja).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al abrir la caja").build();
        }
    }

    @GET
    @Path("/buscar")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response buscarCuadreCaja(@QueryParam("usuario") String usuario,
                                     @QueryParam("fechaInicio") String fechaInicioStr,
                                     @QueryParam("fechaFin") String fechaFinStr,
                                     @QueryParam("estado") Boolean estado,
                                     @QueryParam("idNegocio") Integer idNegocio) {
        try {
            LocalDateTime fechaInicio = fechaInicioStr != null ? LocalDateTime.parse(fechaInicioStr) : null;
            LocalDateTime fechaFin = fechaFinStr != null ? LocalDateTime.parse(fechaFinStr) : null;
            List<CuadreCajaDTO> cuadreCajas = cuadreCajaService.buscarCuadreCaja(usuario, fechaInicio, fechaFin, estado, idNegocio);
            return Response.ok(cuadreCajas).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al buscar cuadre de caja").build();
        }
    }

    @PUT
    @Path("/cerrar")
    @Authenticated
    public Response cerrarCaja(CuadreCajaDTO cuadreCajaDTO) {
        try {
            CuadreCajaDTO closedCuadreCaja = cuadreCajaService.cerrarCaja(cuadreCajaDTO);
            return Response.ok(closedCuadreCaja).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al cerrar la caja").build();
        }
    }

    @GET
    @Path("/activo-usuario")
    @Authenticated
    public Response buscarCuadreCajaActivoPorUsuario(@QueryParam("usuario") String usuario,
                                                     @QueryParam("idNegocio") Integer idNegocio) {
        try {
            CuadreCajaDTO activeCuadreCaja = cuadreCajaService.buscarCuadreCajaActivoPorUsuario(usuario, idNegocio);
            return Response.ok(activeCuadreCaja).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al buscar cuadre de caja activo por usuario").build();
        }
    }

}