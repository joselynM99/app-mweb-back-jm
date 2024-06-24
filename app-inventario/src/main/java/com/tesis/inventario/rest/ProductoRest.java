package com.tesis.inventario.rest;

import com.tesis.inventario.db.*;
import com.tesis.inventario.dtos.ProductoDTO;
import com.tesis.inventario.dtos.ProductoListaDTO;
import com.tesis.inventario.repo.*;
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
import org.eclipse.microprofile.auth.LoginConfig;

import java.util.List;
import java.util.Optional;

@Path("/inventario/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
@Authenticated
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
    @RolesAllowed({"ADMINISTRADOR"})
    public Response registrarProducto(ProductoDTO obj) {
        try {

            Optional<Producto> producto = this.productoRepository.find("codigoBarras", obj.getCodigoBarras()).singleResultOptional();
            Optional<Subproducto> subproducto = this.subproductoRepository.find("codigoBarras", obj.getCodigoBarras()).singleResultOptional();

            if (producto.isPresent() || subproducto.isPresent()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Ya existe un producto o subproducto con el mismo código de barras")
                        .build();
            } else {
                Producto ret = ProductoDTO.from(obj);

                Optional<Proveedor> proveedorOpt = this.proveedorRepository.find("identificacion", obj.getProveedor()).firstResultOptional();
                Optional<Marca> marcaOpt = this.marcaRepository.findByIdOptional(obj.getMarca());
                Optional<Impuesto> impuestoOpt = this.impuestoRepository.findByIdOptional(obj.getImpuesto());
                Optional<Categoria> categoriaOpt = this.categoriaRepository.findByIdOptional(obj.getCategoria());

                if (proveedorOpt.isEmpty() || marcaOpt.isEmpty() || impuestoOpt.isEmpty() || categoriaOpt.isEmpty()) {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Proveedor, Marca, Impuesto o Categoria no encontrados").build();
                }

                ret.setCategoria(categoriaOpt.get());
                ret.setImpuesto(impuestoOpt.get());
                ret.setMarca(marcaOpt.get());
                ret.setProveedor(proveedorOpt.get());

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
    @RolesAllowed({"ADMINISTRADOR"})
    public Response actualizarProducto(@PathParam("codigoBarras") String codigoBarras, ProductoDTO obj) {
        try {
            Optional<Producto> productoOpt = this.productoRepository.find("codigoBarras = ?1 AND activo =?2", codigoBarras, true).singleResultOptional();
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
            ret.setActivo(obj.isActivo());

            // Manejo de excepciones para las busquedas
            Optional<Proveedor> proveedorOpt = this.proveedorRepository.find("identificacion", obj.getProveedor()).firstResultOptional();
            Optional<Marca> marcaOpt = this.marcaRepository.findByIdOptional(obj.getMarca());
            Optional<Impuesto> impuestoOpt = this.impuestoRepository.findByIdOptional(obj.getImpuesto());
            Optional<Categoria> categoriaOpt = this.categoriaRepository.findByIdOptional(obj.getCategoria());

            if (proveedorOpt.isEmpty() || marcaOpt.isEmpty() || impuestoOpt.isEmpty() || categoriaOpt.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Proveedor, Marca, Impuesto o Categoria no encontrados").build();
            }

            ret.setCategoria(categoriaOpt.get());
            ret.setImpuesto(impuestoOpt.get());
            ret.setMarca(marcaOpt.get());
            ret.setProveedor(proveedorOpt.get());
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
    @PermitAll
    public Response obtenerProductoCodigoBarras(@PathParam("codigoBarras") String codigoBarras) {
        try {
            Optional<Producto> productoOpt = this.productoRepository.find("codigoBarras = ?1 AND activo =?2", codigoBarras, true).singleResultOptional();
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
    @PermitAll
    public Response listaProductos() {
        try {
            List<Producto> productosActivos = this.productoRepository.find("activo = ?1", true).list();

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
    @PermitAll
    public Response listaProductosPorNombre(@PathParam("nombre") String nombre) {

        try {
            String consulta = "LOWER(nombre) LIKE CONCAT('%', :nombre, '%') AND activo = true";
            List<Producto> productos = this.productoRepository.list(consulta, Parameters.with("nombre", nombre.toLowerCase()).map());

            if (productos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron productos con el nombre especificado")
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
    @RolesAllowed({"ADMINISTRADOR"})
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
