package com.mweb.inventario.rest;

import com.mweb.inventario.db.Impuesto;
import com.mweb.inventario.dtos.ImpuestoDTO;
import com.mweb.inventario.db.enums.TipoImpuesto;
import com.mweb.inventario.repo.ImpuestoRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/inventario/impuestos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ImpuestoRest {

    @Inject
    ImpuestoRepository impuestoRepository;

    @POST
    @RolesAllowed("ADMINISTRADOR")
    @Transactional
    public Response registrarImpuesto(ImpuestoDTO dto) {
        try {
            Impuesto impuesto = new Impuesto();
            impuesto.setValor(dto.getValor());
            impuesto.setTipoImpuesto(dto.getTipoImpuesto());
            impuesto.setActivo(dto.isActivo());
            impuestoRepository.persist(impuesto);
            return Response.ok("Impuesto registrado exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al registrar el impuesto").build();
        }
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("ADMINISTRADOR")
    @Transactional
    public Response actualizarImpuesto(@PathParam("id") Integer id, ImpuestoDTO dto) {
        try {
            Optional<Impuesto> impuestoOpt = impuestoRepository.findByIdOptional(id);
            if (impuestoOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Impuesto no encontrado").build();
            }
            Impuesto impuesto = impuestoOpt.get();
            impuesto.setValor(dto.getValor());
            impuesto.setTipoImpuesto(dto.getTipoImpuesto());
            impuesto.setActivo(dto.isActivo());
            return Response.ok("Impuesto actualizado exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al actualizar el impuesto").build();
        }
    }

    @GET
    @Path("/{id}")
    public Response obtenerImpuesto(@PathParam("id") Integer id) {
        try {
            Optional<Impuesto> impuestoOpt = impuestoRepository.findByIdOptional(id);
            if (impuestoOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Impuesto no encontrado").build();
            }
            ImpuestoDTO dto = new ImpuestoDTO();
            Impuesto impuesto = impuestoOpt.get();
            dto.setId(impuesto.getId());
            dto.setValor(impuesto.getValor());
            dto.setTipoImpuesto(impuesto.getTipoImpuesto());
            dto.setActivo(impuesto.isActivo());
            return Response.ok(dto).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al obtener el impuesto").build();
        }
    }

    @GET
    public Response listaImpuestos() {
        try {
            List<Impuesto> impuestos = impuestoRepository.listAll();
            List<ImpuestoDTO> impuestosDTO = impuestos.stream().map(impuesto -> {
                ImpuestoDTO dto = new ImpuestoDTO();
                dto.setId(impuesto.getId());
                dto.setValor(impuesto.getValor());
                dto.setTipoImpuesto(impuesto.getTipoImpuesto());
                dto.setActivo(impuesto.isActivo());
                return dto;
            }).collect(Collectors.toList());
            return Response.ok(impuestosDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al obtener la lista de impuestos").build();
        }
    }

    @PATCH
    @Path("/{id}/desactivar")
    @RolesAllowed("ADMINISTRADOR")
    @Transactional
    public Response desactivarImpuesto(@PathParam("id") Integer id) {
        try {
            Optional<Impuesto> impuestoOpt = impuestoRepository.findByIdOptional(id);
            if (impuestoOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Impuesto no encontrado").build();
            }
            Impuesto impuesto = impuestoOpt.get();
            impuesto.setActivo(false);
            return Response.ok("Impuesto desactivado exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al desactivar el impuesto").build();
        }
    }

    @GET
    @Path("/tipos")
    public Response listarTiposImpuestos() {
        try {
            TipoImpuesto[] tipos = TipoImpuesto.values();
            return Response.ok(tipos).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al obtener los tipos de impuestos").build();
        }
    }
}