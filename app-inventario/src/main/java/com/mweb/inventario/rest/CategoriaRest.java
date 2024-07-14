package com.mweb.inventario.rest;

import com.mweb.inventario.db.Categoria;
import com.mweb.inventario.dtos.CategoriaDTO;
import com.mweb.inventario.repo.CategoriaRepository;
import io.quarkus.panache.common.Parameters;
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
@Transactional
public class CategoriaRest {

    @Inject
    CategoriaRepository categoriaRepository;

    @POST
    public Response registrarCategoria(CategoriaDTO obj) {
        try {

            Optional<Categoria> categoria = categoriaRepository.find("nombre", obj.getNombre()).firstResultOptional();

            if (categoria.isPresent()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Ya existe una categoria con el mismo nombre")
                        .build();
            } else {
                Categoria ret = new Categoria();
                ret.setNombre(obj.getNombre());
                ret.setDescripcion(obj.getDescripcion());
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
    public Response actualizarCategoria(@PathParam("id") Integer id, CategoriaDTO obj) {
        try {
            Optional<Categoria> categoriaOpt = categoriaRepository.find("id = ?1 AND activo =?2", id, true).singleResultOptional();

            if (categoriaOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Categoria no encontrada").build();

            }
            Categoria categoria = categoriaOpt.get();
            categoria.setNombre(obj.getNombre());
            categoria.setDescripcion(obj.getDescripcion());

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

            return Response.ok(categoriaDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar la categoria")
                    .build();
        }
    }

    @GET
    public Response listaCategorias() {
        try {
            List<Categoria> categoriasActivos = this.categoriaRepository.find("activo = ?1", true).list();

            if (categoriasActivos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron categorias").build();
            }

            List<CategoriaDTO> categoriasDTO = new ArrayList<>();
            
            for (Categoria categoria: categoriasActivos){
                CategoriaDTO categoriaDTO = new CategoriaDTO();
                categoriaDTO.setNombre(categoria.getNombre());
                categoriaDTO.setId(categoria.getId());
                categoriaDTO.setDescripcion(categoria.getDescripcion());
                categoriaDTO.setActivo(categoria.isActivo());
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
    public Response listaCategoriasPorNombre(@PathParam("nombre") String nombre) {

        try {
            String consulta = "LOWER(nombre) LIKE CONCAT('%', :nombre, '%') AND activo = true";
            List<Categoria> categorias = categoriaRepository.list(consulta, Parameters.with("nombre", nombre.toLowerCase()).map());

            if (categorias.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron categorias con el nombre especificado")
                        .build();
            }

            List<CategoriaDTO> categoriasDTO = new ArrayList<>();

            for (Categoria categoria: categorias){
                CategoriaDTO categoriaDTO = new CategoriaDTO();
                categoriaDTO.setNombre(categoria.getNombre());
                categoriaDTO.setId(categoria.getId());
                categoriaDTO.setDescripcion(categoria.getDescripcion());
                categoriaDTO.setActivo(categoria.isActivo());

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
