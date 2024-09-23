package com.mweb.inventario.rest;

import com.mweb.inventario.db.Categoria;
import com.mweb.inventario.dtos.CategoriaDTO;
import com.mweb.inventario.repo.CategoriaRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.annotation.security.PermitAll;
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

@Path("/inventario/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class CategoriaRest {

    @Inject
    CategoriaRepository categoriaRepository;

    @POST
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response registrarCategoria(CategoriaDTO obj) {
        try {

            Optional<Categoria> categoria = categoriaRepository.find("nombre = ?1 AND activo = true AND idNegocio = ?2", obj.getNombre(), obj.getIdNegocio()).firstResultOptional();
            if (categoria.isPresent()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Ya existe una categoria con el mismo nombre")
                        .build();
            } else {
                Categoria ret = new Categoria();
                ret.setNombre(obj.getNombre());
                ret.setDescripcion(obj.getDescripcion());
                ret.setIdNegocio(obj.getIdNegocio());
                ret.setActivo(true);
                categoriaRepository.persist(ret);
                return Response.ok("Categoria registrada exitosamente").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al registrar la categoria")
                    .build();
        }

    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response actualizarCategoria(@PathParam("id") Integer id, CategoriaDTO obj) {
        try {
            Optional<Categoria> categoriaOpt = categoriaRepository.find("id = ?1 AND activo =?2", id, true).singleResultOptional();

            if (categoriaOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Categoria no encontrada").build();

            }
            Categoria categoria = categoriaOpt.get();
            categoria.setNombre(obj.getNombre());
            categoria.setDescripcion(obj.getDescripcion());
            categoria.setIdNegocio(obj.getIdNegocio());

            return Response.ok("Categoria actualizada exitosamente").build();

        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al actualizar la categoria")
                    .build();
        }

    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response obtenerCategoriaId(@PathParam("id") String id) {
        try {
            Optional<Categoria> categoriaOpt = categoriaRepository.find("id = ?1 AND activo =?2", id, true).singleResultOptional();
            if (categoriaOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Categoria no encontrado").build();
            }

            CategoriaDTO categoriaDTO = new CategoriaDTO();
            categoriaDTO.setId(categoriaOpt.get().getId());
            categoriaDTO.setActivo(categoriaOpt.get().isActivo());
            categoriaDTO.setNombre(categoriaOpt.get().getNombre());
            categoriaDTO.setDescripcion(categoriaOpt.get().getDescripcion());
            categoriaDTO.setIdNegocio(categoriaOpt.get().getIdNegocio());

            return Response.ok(categoriaDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar la categoria")
                    .build();
        }
    }

    @GET
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response listaCategorias(@QueryParam("idNegocio") Integer idNegocio) {
        try {
            List<Categoria> categoriasActivos = this.categoriaRepository.find("activo = ?1 AND idNegocio = ?2", true, idNegocio).list();

            if (categoriasActivos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron categorias").build();
            }

            List<CategoriaDTO> categoriasDTO = new ArrayList<>();

            for (Categoria categoria : categoriasActivos) {
                CategoriaDTO categoriaDTO = new CategoriaDTO();
                categoriaDTO.setNombre(categoria.getNombre());
                categoriaDTO.setId(categoria.getId());
                categoriaDTO.setDescripcion(categoria.getDescripcion());
                categoriaDTO.setActivo(categoria.isActivo());
                categoriaDTO.setIdNegocio(categoria.getIdNegocio());
                categoriasDTO.add(categoriaDTO);
            }


            return Response.ok(categoriasDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener las categorias")
                    .build();
        }


    }

    @GET
    @Path("/buscar-por-nombre/{nombre}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response listaCategoriasPorNombre(@PathParam("nombre") String nombre, @QueryParam("idNegocio") Integer idNegocio) {

        try {
            String consulta = "LOWER(nombre) LIKE CONCAT('%', :nombre, '%') AND activo = true AND idNegocio = :idNegocio";
            List<Categoria> categorias = categoriaRepository.list(consulta, Parameters.with("nombre", nombre.toLowerCase()).and("idNegocio", idNegocio).map());

            if (categorias.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron categorias con el nombre especificado")
                        .build();
            }

            List<CategoriaDTO> categoriasDTO = new ArrayList<>();

            for (Categoria categoria : categorias) {
                CategoriaDTO categoriaDTO = new CategoriaDTO();
                categoriaDTO.setNombre(categoria.getNombre());
                categoriaDTO.setId(categoria.getId());
                categoriaDTO.setDescripcion(categoria.getDescripcion());
                categoriaDTO.setActivo(categoria.isActivo());
                categoriaDTO.setIdNegocio(categoria.getIdNegocio());

                categoriasDTO.add(categoriaDTO);
            }
            return Response.ok(categoriasDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los categorias")
                    .build();
        }
    }

    @PATCH
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response desactivarCategoria(@PathParam("id") Integer id) {
        try {
            Optional<Categoria> categoriaOptional = this.categoriaRepository.findByIdOptional(id);

            if (categoriaOptional.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontró la categoria")
                        .build();
            }
            Categoria categoria = categoriaOptional.get();
            categoria.setActivo(false);
            return Response.ok("Categoria eliminada").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al desactivar la categoria")
                    .build();
        }
    }
}
