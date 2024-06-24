package com.tesis.inventario.rest;

import com.tesis.inventario.db.Proveedor;
import com.tesis.inventario.db.enums.TipoIdentificacion;
import com.tesis.inventario.dtos.ProveedorDTO;
import com.tesis.inventario.repo.ProveedorRepository;
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

@Path("/inventario/proveedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
@Authenticated
public class ProveedorRest {

    @Inject
    ProveedorRepository proveedorRepository;

    @POST
    @RolesAllowed({"ADMINISTRADOR"})
    public Response registrarProveedor(ProveedorDTO obj) {
        try {

            Optional<Proveedor> proveedor = this.proveedorRepository.find("identificacion", obj.getIdentificacion()).singleResultOptional();

            if (proveedor.isPresent()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Ya existe un proveedor con el mismo código de barras")
                        .build();
            } else {
                Proveedor ret = ProveedorDTO.from(obj);
                this.proveedorRepository.persist(ret);
                return Response.ok("Proveedor registrado exitosamente").build();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al registrar el proveedor")
                    .build();
        }

    }

    @PUT
    @Path("/{identificacion}")
    @RolesAllowed({"ADMINISTRADOR"})
    public Response actualizarProveedor(@PathParam("identificacion") String identificacion, ProveedorDTO obj) {
        try {
            Optional<Proveedor> proveedorOpt = this.proveedorRepository.find("identificacion = ?1 AND activo =?2", identificacion, true).singleResultOptional();

            if (proveedorOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Proveedor no encontrado").build();

            }
            Proveedor proveedor = proveedorOpt.get();
            proveedor.setTipoIdentificacion(TipoIdentificacion.valueOf(obj.getTipoIdentificacion()));
            proveedor.setIdentificacion(obj.getIdentificacion());
            proveedor.setRazonSocial(obj.getRazonSocial());
            proveedor.setNombreComercial(obj.getNombreComercial());
            proveedor.setTelefono(obj.getTelefono());
            proveedor.setCorreo(obj.getCorreo());
            proveedor.setDireccion(obj.getDireccion());
            proveedor.setActivo(obj.isActivo());

            return Response.ok("Proveedor actualizado exitosamente").build();

        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al actualizar el proveedor")
                    .build();
        }

    }

    @GET
    @Path("/{identificacion}")
    @RolesAllowed({"ADMINISTRADOR"})
    public Response obtenerProveedorIdentificacion(@PathParam("identificacion") String identificacion) {
        try {

            Optional<Proveedor> proveedorOpt = this.proveedorRepository.find("identificacion = ?1 AND activo =?2", identificacion, true).singleResultOptional();
            if (proveedorOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Proveedor no encontrado").build();
            }

            ProveedorDTO proveedorDTO = ProveedorDTO.from(proveedorOpt.get());
            proveedorDTO.setId(proveedorOpt.get().getId());
            return Response.ok(proveedorDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar el proveedor")
                    .build();
        }
    }

    @GET
    @RolesAllowed({"ADMINISTRADOR"})
    public Response listaProveedores() {
        try {
            List<Proveedor> proveedoresActivos = this.proveedorRepository.find("activo = ?1", true).list();

            if (proveedoresActivos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron proveedores").build();
            }

            List<ProveedorDTO> proveedoresDTO = ProveedorDTO.fromProveedoresDTO(proveedoresActivos);

            return Response.ok(proveedoresDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los proveedores")
                    .build();
        }


    }

    @GET
    @Path("/buscar-por-nombre/{nombreComercial}")
    @RolesAllowed({"ADMINISTRADOR"})
    public Response listaProveedoresPorNombreComercial(@PathParam("nombreComercial") String nombreComercial) {

        try {
            String consulta = "LOWER(nombreComercial) LIKE CONCAT('%', :nombreComercial, '%') AND activo = true";
            List<Proveedor> proveedores = this.proveedorRepository.list(consulta, Parameters.with("nombreComercial", nombreComercial.toLowerCase()).map());

            if (proveedores.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron proveedores con el nombre especificado")
                        .build();
            }

            List<ProveedorDTO> proveedoresDTO = ProveedorDTO.fromProveedoresDTO(proveedores);
            return Response.ok(proveedoresDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los proveedores")
                    .build();
        }


    }


    @PATCH
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRADOR"})
    public Response desactivarProveedor(@PathParam("id") Integer id) {
        try {
            Optional<Proveedor> proveedorOptional = this.proveedorRepository.findByIdOptional(id);

            if (proveedorOptional.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontró el proveedor")
                        .build();
            }
            Proveedor proveedor = proveedorOptional.get();
            proveedor.setActivo(false);
            return Response.ok("Proveedor eliminado").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al desactivar el proveedor")
                    .build();
        }
    }
}
