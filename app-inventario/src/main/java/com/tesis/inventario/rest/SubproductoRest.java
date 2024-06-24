package com.tesis.inventario.rest;

import com.tesis.inventario.db.*;
import com.tesis.inventario.dtos.ProductoDTO;
import com.tesis.inventario.dtos.ProductoListaDTO;
import com.tesis.inventario.dtos.SubproductoDTO;
import com.tesis.inventario.repo.*;
import io.quarkus.panache.common.Parameters;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/inventario/subproductos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class SubproductoRest {

    @Inject
    SubproductoRepository subproductoRepository;
    @Inject
    ProductoRepository productoRepository;
    @Inject
    CategoriaRepository categoriaRepository;
    @Inject
    ImpuestoRepository impuestoRepository;


    @POST
    @RolesAllowed({"ADMINISTRADOR"})
    public Response registrarSubproducto(SubproductoDTO obj) {
        try {

            Optional<Producto> producto = this.productoRepository.find("codigoBarras", obj.getCodigoBarras()).singleResultOptional();
            Optional<Subproducto> subproducto = this.subproductoRepository.find("codigoBarras", obj.getCodigoBarras()).singleResultOptional();

            if (producto.isPresent() || subproducto.isPresent()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Ya existe un producto o subproducto con el mismo código de barras")
                        .build();
            } else {
                Subproducto ret = SubproductoDTO.from(obj);

                Optional<Impuesto> impuestoOpt = this.impuestoRepository.findByIdOptional(obj.getImpuesto());
                Optional<Categoria> categoriaOpt = this.categoriaRepository.findByIdOptional(obj.getCategoria());
                producto = this.productoRepository.find("codigoBarras", obj.getProducto()).singleResultOptional();

                if (impuestoOpt.isEmpty() || categoriaOpt.isEmpty() || producto.isEmpty()) {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Producto, Impuesto o Categoria no encontrados").build();
                }

                ret.setProducto(producto.get());
                ret.setCategoria(categoriaOpt.get());
                ret.setImpuesto(impuestoOpt.get());

                this.subproductoRepository.persist(ret);
                return Response.ok("Subproducto registrado exitosamente").build();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al registrar el subproducto")
                    .build();
        }
    }

    @PUT
    @Path("/{codigoBarras}")
    @RolesAllowed({"ADMINISTRADOR"})
    public Response actualizarSubproducto(@PathParam("codigoBarras") String codigoBarras, SubproductoDTO obj) {
        try {
            Optional<Subproducto> subproductoOpt = this.subproductoRepository.find("codigoBarras = ?1 AND activo =?2", codigoBarras, true).singleResultOptional();
            if (subproductoOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Subproducto no encontrado").build();
            }

            Subproducto ret = subproductoOpt.get();
            ret.setDescripcion(obj.getDescripcion());
            ret.setNombre(obj.getNombre());
            ret.setCodigoBarras(obj.getCodigoBarras());
            ret.setCostoPromedio(obj.getCostoPromedio());
            ret.setPrecioSinImpuestos(obj.getPrecioSinImpuestos());
            ret.setPrecioVenta(obj.getPrecioVenta());
            ret.setStockActual(obj.getStockActual());
            ret.setActivo(obj.isActivo());

            // Manejo de excepciones para las busquedas
            Optional<Producto> producto = this.productoRepository.find("codigoBarras", obj.getProducto()).singleResultOptional();
            Optional<Impuesto> impuestoOpt = this.impuestoRepository.findByIdOptional(obj.getImpuesto());
            Optional<Categoria> categoriaOpt = this.categoriaRepository.findByIdOptional(obj.getCategoria());

            if (producto.isEmpty() || impuestoOpt.isEmpty() || categoriaOpt.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Producto, Impuesto o Categoria no encontrados").build();
            }

            ret.setCategoria(categoriaOpt.get());
            ret.setImpuesto(impuestoOpt.get());
            ret.setProducto(producto.get());
            return Response.ok("Subproducto actualizado exitosamente").build();

        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al actualizar el subproducto")
                    .build();
        }
    }

    @GET
    @Path("/{codigoBarras}")
    @PermitAll
    public Response obtenerSubproductoCodigoBarras(@PathParam("codigoBarras") String codigoBarras) {
        try {
            Optional<Subproducto> subproductoOpt = this.subproductoRepository.find("codigoBarras = ?1 AND activo =?2", codigoBarras, true).singleResultOptional();
            if (subproductoOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Subproducto no encontrado").build();
            }
            SubproductoDTO subproductoDTO = SubproductoDTO.from(subproductoOpt.get());
            return Response.ok(subproductoDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar el subproducto")
                    .build();
        }
    }

    @GET
    @PermitAll
    public Response listaSubproductos() {
        try {
            List<Subproducto> subproductosActivos = this.subproductoRepository.find("activo = ?1", true).list();


            if (subproductosActivos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron subproductos").build();
            }

            List<ProductoListaDTO> subproductosDTO = ProductoListaDTO.fromSubproductos(subproductosActivos);
            return Response.ok(subproductosDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los subproductos")
                    .build();
        }


    }

    @GET
    @Path("/buscar-por-nombre/{nombre}")
    @PermitAll
    public Response listaSubproductosPorNombre(@PathParam("nombre") String nombre) {

        try {
            String consulta = "LOWER(nombre) LIKE CONCAT('%', :nombre, '%') AND activo = true";
            List<Subproducto> subproductos = this.subproductoRepository.list(consulta, Parameters.with("nombre", nombre.toLowerCase()).map());

            if (subproductos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron subproductos con el nombre especificado")
                        .build();
            }

            List<ProductoListaDTO> subproductosDTO = ProductoListaDTO.fromSubproductos(subproductos);
            return Response.ok(subproductosDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los subproductos")
                    .build();
        }


    }


    @PATCH
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRADOR"})
    public Response desactivarSubproducto(@PathParam("id") Integer id) {
        try {
            Optional<Subproducto> subproductoOptional = this.subproductoRepository.findByIdOptional(id);

            if (subproductoOptional.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontro el subproducto")
                        .build();
            }
            Subproducto subproducto = subproductoOptional.get();
            subproducto.setActivo(false);
            return Response.ok("Subproducto eliminado").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al desactivar el subproducto")
                    .build();
        }
    }


}
