package com.mweb.inventario.rest;

import com.mweb.inventario.db.*;
import com.mweb.inventario.dtos.ProductoDTO;
import com.mweb.inventario.dtos.ProductoListaDTO;
import com.mweb.inventario.repo.*;
import io.quarkus.panache.common.Parameters;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/inventario/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ProductoRest {

    @Inject
    ProductoRepository productoRepository;

    @Inject
    SubproductoRepository subproductoRepository;
    @Inject
    ProveedorRepository proveedorRepository;
    @Inject
    MarcaRepository marcaRepository;
    @Inject
    CategoriaRepository categoriaRepository;
    @Inject
    ImpuestoRepository impuestoRepository;


    @POST
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response registrarProducto(ProductoDTO obj) {
        try {
            Optional<Producto> producto = this.productoRepository.find("codigoBarras = ?1 AND activo = true AND idNegocio = ?2", obj.getCodigoBarras(), obj.getIdNegocio()).singleResultOptional();
            Optional<Subproducto> subproducto = this.subproductoRepository.find("codigoBarras = ?1 AND activo = true AND idNegocio = ?2", obj.getCodigoBarras(), obj.getIdNegocio()).singleResultOptional();

            if (producto.isPresent() || subproducto.isPresent()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Ya existe un producto o subproducto con el mismo código de barras para este negocio")
                        .build();
            } else {
                Producto ret = ProductoDTO.from(obj);

                if (obj.getProveedor() != null) {
                    Optional<Proveedor> proveedorOpt = this.proveedorRepository.find("identificacion = ?1 AND idNegocio = ?2", obj.getProveedor(), obj.getIdNegocio()).firstResultOptional();
                    if (proveedorOpt.isEmpty()) {
                        return Response.status(Response.Status.BAD_REQUEST).entity("Proveedor no encontrado").build();
                    }
                    ret.setProveedor(proveedorOpt.get());
                }

                if (obj.getMarca() != null) {
                    Optional<Marca> marcaOpt = this.marcaRepository.findByIdOptional(obj.getMarca());
                    if (marcaOpt.isEmpty()) {
                        return Response.status(Response.Status.BAD_REQUEST).entity("Marca no encontrada").build();
                    }
                    ret.setMarca(marcaOpt.get());
                }

                if (obj.getCategoria() != null) {
                    Optional<Categoria> categoriaOpt = this.categoriaRepository.findByIdOptional(obj.getCategoria());
                    if (categoriaOpt.isEmpty()) {
                        return Response.status(Response.Status.BAD_REQUEST).entity("Categoría no encontrada").build();
                    }
                    ret.setCategoria(categoriaOpt.get());
                }

                Optional<Impuesto> impuestoOpt = this.impuestoRepository.findByIdOptional(obj.getImpuesto());
                if (impuestoOpt.isEmpty()) {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Impuesto no encontrado").build();
                }
                ret.setImpuesto(impuestoOpt.get());

                ret.setActivo(true);
                ret.setIdNegocio(obj.getIdNegocio());

                this.productoRepository.persist(ret);
                return Response.ok("Producto registrado exitosamente").build();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al registrar el producto")
                    .build();
        }
    }

    @PUT
    @Path("/{codigoBarras}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response actualizarProducto(@PathParam("codigoBarras") String codigoBarras, ProductoDTO obj) {
        try {
            Optional<Producto> productoOpt = this.productoRepository.find("codigoBarras = ?1 AND activo =?2 AND idNegocio = ?3", codigoBarras, true, obj.getIdNegocio()).singleResultOptional();
            if (productoOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Producto no encontrado").build();
            }

            Producto ret = productoOpt.get();
            ret.setDescripcion(obj.getDescripcion());
            ret.setNombre(obj.getNombre());
            ret.setCodigoBarras(obj.getCodigoBarras());
            ret.setCostoPromedio(obj.getCostoPromedio());
            ret.setPrecioSinImpuestos(obj.getPrecioSinImpuestos());
            ret.setPrecioVenta(obj.getPrecioVenta());
            ret.setStockActual(obj.getStockActual());

            if (obj.getProveedor() != null) {
                Optional<Proveedor> proveedorOpt = this.proveedorRepository.find("identificacion = ?1 AND idNegocio = ?2", obj.getProveedor(), obj.getIdNegocio()).firstResultOptional();
                if (proveedorOpt.isEmpty()) {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Proveedor no encontrado").build();
                }
                ret.setProveedor(proveedorOpt.get());
            }

            if (obj.getMarca() != null) {
                Optional<Marca> marcaOpt = this.marcaRepository.findByIdOptional(obj.getMarca());
                if (marcaOpt.isEmpty()) {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Marca no encontrada").build();
                }
                ret.setMarca(marcaOpt.get());
            }

            if (obj.getCategoria() != null) {
                Optional<Categoria> categoriaOpt = this.categoriaRepository.findByIdOptional(obj.getCategoria());
                if (categoriaOpt.isEmpty()) {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Categoría no encontrada").build();
                }
                ret.setCategoria(categoriaOpt.get());
            }

            Optional<Impuesto> impuestoOpt = this.impuestoRepository.findByIdOptional(obj.getImpuesto());
            if (impuestoOpt.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Impuesto no encontrado").build();
            }
            ret.setImpuesto(impuestoOpt.get());

            ret.setIdNegocio(obj.getIdNegocio());
            return Response.ok("Producto actualizado exitosamente").build();

        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al actualizar el producto")
                    .build();
        }
    }

    @GET
    @Path("/{codigoBarras}")
    @Authenticated
    public Response obtenerProductoCodigoBarras(@PathParam("codigoBarras") String codigoBarras, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            Optional<Producto> productoOpt = this.productoRepository.find("codigoBarras = ?1 AND activo = ?2 AND idNegocio = ?3", codigoBarras, true, idNegocio).singleResultOptional();
            if (productoOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Producto no encontrado").build();
            }
            ProductoDTO productoDTO = ProductoDTO.from(productoOpt.get());
            return Response.ok(productoDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar el producto")
                    .build();
        }
    }

    @GET
    @Path("/{codigoBarras}/proveedor/{proveedorId}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response obtenerProductoPorCodigoBarrasYProveedor(@PathParam("codigoBarras") String codigoBarras, @PathParam("proveedorId") String proveedorId, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            Optional<Producto> productoOpt = this.productoRepository.find("codigoBarras = :codigoBarras AND proveedor.identificacion = :proveedorId AND activo = :activo AND idNegocio = :idNegocio",
                            Parameters.with("codigoBarras", codigoBarras)
                                    .and("proveedorId", proveedorId)
                                    .and("activo", true)
                                    .and("idNegocio", idNegocio))
                    .singleResultOptional();
            if (productoOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Producto no encontrado").build();
            }
            ProductoDTO productoDTO = ProductoDTO.from(productoOpt.get());
            return Response.ok(productoDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar el producto")
                    .build();
        }
    }

    @GET
    @Authenticated
    public Response listaProductos(@QueryParam("idNegocio") Integer idNegocio) {
        try {
            List<Producto> productosActivos = this.productoRepository.find("activo = ?1 AND idNegocio = ?2", true, idNegocio).list();

            if (productosActivos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron productos").build();
            }

            List<ProductoListaDTO> productosDTO = ProductoListaDTO.fromProductos(productosActivos);
            return Response.ok(productosDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los productos")
                    .build();
        }
    }

    @GET
    @Path("/proveedor/{proveedorId}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response listaProductosPorProveedor(@QueryParam("idNegocio") Integer idNegocio, @PathParam("proveedorId") String proveedorId) {
        try {
            List<Producto> productosActivos = this.productoRepository.find("activo = ?1 AND idNegocio = ?2 AND proveedor.identificacion = ?3", true, idNegocio, proveedorId).list();

            if (productosActivos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron productos").build();
            }

            List<ProductoListaDTO> productosDTO = ProductoListaDTO.fromProductos(productosActivos);
            return Response.ok(productosDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los productos")
                    .build();
        }
    }

    @GET
    @Path("/buscar-por-nombre/{nombre}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response listaProductosPorNombre(@PathParam("nombre") String nombre, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            String consulta = "LOWER(nombre) LIKE CONCAT('%', :nombre, '%') AND activo = true AND idNegocio = :idNegocio";
            List<Producto> productos = this.productoRepository.list(consulta, Parameters.with("nombre", nombre.toLowerCase())
                    .and("idNegocio", idNegocio)
                    .map());

            if (productos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron productos con el nombre y proveedor especificados")
                        .build();
            }

            List<ProductoListaDTO> productosDTO = ProductoListaDTO.fromProductos(productos);
            return Response.ok(productosDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los productos")
                    .build();
        }
    }


    @GET
    @Path("/buscar-por-nombre/{nombre}/proveedor/{proveedorId}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response listaProductosPorNombreYProveedor(@PathParam("nombre") String nombre, @PathParam("proveedorId") String proveedorId, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            String consulta = "LOWER(nombre) LIKE CONCAT('%', :nombre, '%') AND activo = true AND idNegocio = :idNegocio AND proveedor.identificacion = :proveedorId";
            List<Producto> productos = this.productoRepository.list(consulta, Parameters.with("nombre", nombre.toLowerCase())
                    .and("idNegocio", idNegocio)
                    .and("proveedorId", proveedorId)
                    .map());

            if (productos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron productos con el nombre y proveedor especificados")
                        .build();
            }

            List<ProductoListaDTO> productosDTO = ProductoListaDTO.fromProductos(productos);
            return Response.ok(productosDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los productos")
                    .build();
        }
    }

    @PATCH
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response desactivarProducto(@PathParam("id") Integer id) {
        try {
            Optional<Producto> productoOptional = this.productoRepository.findByIdOptional(id);

            if (productoOptional.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontró el producto")
                        .build();
            }
            Producto producto = productoOptional.get();
            producto.setActivo(false);
            return Response.ok("Producto eliminado").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al desactivar el producto")
                    .build();
        }
    }


}
