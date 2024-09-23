package com.mweb.inventario.rest;

import com.mweb.inventario.db.Marca;
import com.mweb.inventario.dtos.MarcaDTO;
import com.mweb.inventario.repo.MarcaRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/inventario/marcas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class MarcaRest {

    @Inject
    MarcaRepository marcaRepository;

    @POST
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response registrarMarca(MarcaDTO obj) {
        try {
            Optional<Marca> marca = marcaRepository.find("nombre = ?1 AND activo = true AND idNegocio = ?2", obj.getNombre(), obj.getIdNegocio()).firstResultOptional();

            if (marca.isPresent()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Ya existe una marca con el mismo nombre para este negocio")
                        .build();
            } else {
                Marca ret = new Marca();
                ret.setNombre(obj.getNombre());
                ret.setActivo(true);
                ret.setIdNegocio(obj.getIdNegocio());
                marcaRepository.persist(ret);
                return Response.ok("Marca registrada exitosamente").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al registrar la marca")
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response actualizarMarca(@PathParam("id") Integer id, MarcaDTO obj) {
        try {
            Optional<Marca> marcaOpt = marcaRepository.find("id = ?1 AND activo =?2 AND idNegocio = ?3", id, true, obj.getIdNegocio()).singleResultOptional();

            if (marcaOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Marca no encontrada").build();
            }

            Marca marca = marcaOpt.get();
            marca.setNombre(obj.getNombre());
            marca.setIdNegocio(obj.getIdNegocio());

            return Response.ok("Marca actualizada exitosamente").build();

        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al actualizar la marca")
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response obtenerMarcaId(@PathParam("id") String id) {
        try {

            Optional<Marca> marcaOpt = marcaRepository.find("id = ?1 AND activo =?2", id, true).singleResultOptional();
            if (marcaOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Marca no encontrado").build();
            }

            MarcaDTO marcaDTO = new MarcaDTO();
            marcaDTO.setId(marcaOpt.get().getId());
            marcaDTO.setActivo(marcaOpt.get().isActivo());
            marcaDTO.setNombre(marcaOpt.get().getNombre());
            marcaDTO.setActivo(marcaOpt.get().isActivo());
            marcaDTO.setIdNegocio(marcaOpt.get().getIdNegocio());
            return Response.ok(marcaDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar la marca")
                    .build();
        }
    }

    @GET
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response listaMarcas(@QueryParam("idNegocio") Integer idNegocio) {
        try {
            List<Marca> marcasActivos = this.marcaRepository.find("activo = ?1 AND idNegocio = ?2", true, idNegocio).list();

            if (marcasActivos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron marcas").build();
            }

            List<MarcaDTO> marcasDTO = new ArrayList<>();

            for (Marca marca : marcasActivos) {
                MarcaDTO marcaDTO = new MarcaDTO();
                marcaDTO.setNombre(marca.getNombre());
                marcaDTO.setId(marca.getId());
                marcaDTO.setActivo(marca.isActivo());
                marcaDTO.setIdNegocio(marca.getIdNegocio());
                marcasDTO.add(marcaDTO);
            }

            return Response.ok(marcasDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener las marcas")
                    .build();
        }
    }

    @GET
    @Path("/buscar-por-nombre/{nombre}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response listaMarcasPorNombre(@PathParam("nombre") String nombre, @QueryParam("idNegocio") Integer idNegocio) {

        try {
            String consulta = "LOWER(nombre) LIKE CONCAT('%', :nombre, '%') AND activo = true AND idNegocio = :idNegocio";
            List<Marca> marcas = marcaRepository.list(consulta, Parameters.with("nombre", nombre.toLowerCase()).and("idNegocio", idNegocio).map());

            if (marcas.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron marcas con el nombre especificado")
                        .build();
            }

            List<MarcaDTO> marcasDTO = new ArrayList<>();

            for (Marca marca : marcas) {
                MarcaDTO marcaDTO = new MarcaDTO();
                marcaDTO.setNombre(marca.getNombre());
                marcaDTO.setId(marca.getId());
                marcaDTO.setActivo(marca.isActivo());
                marcaDTO.setIdNegocio(marca.getIdNegocio());
                marcasDTO.add(marcaDTO);
            }
            return Response.ok(marcasDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los marcas")
                    .build();
        }
    }

    @PATCH
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response desactivarMarca(@PathParam("id") Integer id) {
        try {
            Optional<Marca> marcaOptional = this.marcaRepository.findByIdOptional(id);

            if (marcaOptional.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontró la marca")
                        .build();
            }
            Marca marca = marcaOptional.get();
            marca.setActivo(false);
            return Response.ok("Marca eliminada").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al desactivar la marca")
                    .build();
        }
    }
}
