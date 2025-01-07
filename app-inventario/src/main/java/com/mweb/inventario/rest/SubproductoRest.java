package com.mweb.inventario.rest;

import com.mweb.inventario.db.Categoria;
import com.mweb.inventario.db.Impuesto;
import com.mweb.inventario.db.Producto;
import com.mweb.inventario.db.Subproducto;
import com.mweb.inventario.dtos.ProductoListaDTO;
import com.mweb.inventario.dtos.SubproductoDTO;
import com.mweb.inventario.repo.CategoriaRepository;
import com.mweb.inventario.repo.ImpuestoRepository;
import com.mweb.inventario.repo.ProductoRepository;
import com.mweb.inventario.repo.SubproductoRepository;
import io.quarkus.panache.common.Parameters;
import io.quarkus.security.Authenticated;
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
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response registrarSubproducto(SubproductoDTO obj) {
        try {
            Optional<Producto> producto = this.productoRepository.find("codigoBarras = ?1 AND activo = true AND idNegocio = ?2", obj.getCodigoBarras(), obj.getIdNegocio()).singleResultOptional();
            Optional<Subproducto> subproducto = this.subproductoRepository.find("codigoBarras = ?1 AND activo = true AND idNegocio = ?2", obj.getCodigoBarras(), obj.getIdNegocio()).singleResultOptional();
            if (producto.isPresent() || subproducto.isPresent()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Ya existe un producto o subproducto con el mismo código de barras")
                        .build();
            } else {
                Subproducto ret = SubproductoDTO.from(obj);

                Optional<Impuesto> impuestoOpt = this.impuestoRepository.findByIdOptional(obj.getImpuesto());
                if (impuestoOpt.isEmpty()) {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Impuesto no encontrado").build();
                }

                Optional<Categoria> categoriaOpt = Optional.empty();
                if (obj.getCategoria() != null) {
                    categoriaOpt = this.categoriaRepository.findByIdOptional(obj.getCategoria());
                    if (categoriaOpt.isEmpty()) {
                        return Response.status(Response.Status.BAD_REQUEST).entity("Categoría no encontrada").build();
                    }
                }

                producto = this.productoRepository.find("codigoBarras = ?1 AND idNegocio = ?2", obj.getProducto(), obj.getIdNegocio()).singleResultOptional();
                if (producto.isEmpty()) {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Producto no encontrado").build();
                }

                ret.setProducto(producto.get());
                ret.setImpuesto(impuestoOpt.get());
                categoriaOpt.ifPresent(ret::setCategoria);
                ret.setActivo(true);
                ret.setIdNegocio(obj.getIdNegocio());

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
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response actualizarSubproducto(@PathParam("codigoBarras") String codigoBarras, SubproductoDTO obj) {
        try {
            Optional<Subproducto> subproductoOpt = this.subproductoRepository.find("codigoBarras = ?1 AND activo =?2 AND idNegocio = ?3", codigoBarras, true, obj.getIdNegocio()).singleResultOptional();
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

            Optional<Producto> producto = this.productoRepository.find("codigoBarras = ?1 AND idNegocio = ?2", obj.getProducto(), obj.getIdNegocio()).singleResultOptional();
            if (producto.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Producto no encontrado").build();
            }

            Optional<Impuesto> impuestoOpt = this.impuestoRepository.findByIdOptional(obj.getImpuesto());
            if (impuestoOpt.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Impuesto no encontrado").build();
            }

            Optional<Categoria> categoriaOpt = Optional.empty();
            if (obj.getCategoria() != null) {
                categoriaOpt = this.categoriaRepository.findByIdOptional(obj.getCategoria());
                if (categoriaOpt.isEmpty()) {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Categoría no encontrada").build();
                }
            }

            ret.setProducto(producto.get());
            ret.setImpuesto(impuestoOpt.get());
            categoriaOpt.ifPresent(ret::setCategoria);
            ret.setIdNegocio(obj.getIdNegocio());
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
    @Authenticated
    public Response obtenerSubproductoCodigoBarras(@PathParam("codigoBarras") String codigoBarras, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            Optional<Subproducto> subproductoOpt = this.subproductoRepository.find("codigoBarras = ?1 AND activo =?2 AND idNegocio = ?3", codigoBarras, true, idNegocio).singleResultOptional();
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
    @Authenticated
    public Response listaSubproductos(@QueryParam("idNegocio") Integer idNegocio) {
        try {
            List<Subproducto> subproductosActivos = this.subproductoRepository.find("activo = ?1 AND idNegocio = ?2", true, idNegocio).list();

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
    @Authenticated
    public Response listaSubproductosPorNombre(@PathParam("nombre") String nombre, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            String consulta = "SELECT s FROM Subproducto s LEFT JOIN FETCH s.categoria LEFT JOIN FETCH s.impuesto LEFT JOIN FETCH s.producto p LEFT JOIN FETCH p.proveedor LEFT JOIN FETCH p.marca WHERE LOWER(s.nombre) LIKE CONCAT('%', :nombre, '%') AND s.activo = true AND s.idNegocio = :idNegocio";
            List<Subproducto> subproductos = this.subproductoRepository.list(consulta, Parameters.with("nombre", nombre.toLowerCase()).and("idNegocio", idNegocio).map());

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

    @GET
    @Path("/buscar-por-producto/{codigo}")
    @Authenticated
    public Response listaSubproductosPorProducto(@PathParam("codigo") String codigo, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            Optional<Producto> productoOpt = this.productoRepository.find("codigoBarras = ?1 AND idNegocio = ?2 AND activo = true", codigo, idNegocio).singleResultOptional();
            if (productoOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontró el producto con el código de barras especificado")
                        .build();
            }

            Producto producto = productoOpt.get();

            List<Subproducto> subproductos = producto.getSubproductos();

            if (subproductos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron subproductos para el producto especificado")
                        .build();
            }

            List<SubproductoDTO> subproductosDTO = SubproductoDTO.fromSubproductos(subproductos);
            return Response.ok(subproductosDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los subproductos")
                    .build();
        }
    }

    @GET
    @Path("/buscar-por-producto/{codigo}/proveedor/{proveedorId}")

    public Response listaSubproductosPorProductoYProveedor(@PathParam("codigo") String codigo, @PathParam("proveedorId") String proveedorId, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            Optional<Producto> productoOpt = this.productoRepository.find("codigoBarras = ?1 AND idNegocio = ?2 AND activo = true AND proveedor.identificacion = ?3", codigo, idNegocio, proveedorId).singleResultOptional();
            if (productoOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontró el producto con el código de barras y proveedor especificados")
                        .build();
            }

            Producto producto = productoOpt.get();

            List<Subproducto> subproductos = producto.getSubproductos();

            if (subproductos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron subproductos para el producto y proveedor especificados")
                        .build();
            }

            List<SubproductoDTO> subproductosDTO = SubproductoDTO.fromSubproductos(subproductos);
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
    @Transactional
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
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
