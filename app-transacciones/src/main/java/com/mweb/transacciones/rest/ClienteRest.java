package com.mweb.transacciones.rest;

import com.mweb.transacciones.db.Cliente;
import com.mweb.transacciones.db.enums.TipoIdentificacion;
import com.mweb.transacciones.dtos.ClienteDTO;
import com.mweb.transacciones.repo.ClienteRepository;
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

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ClienteRest {

    @Inject
    ClienteRepository clienteRepository;

    @GET
    @Authenticated
    public Response listaClientes(@QueryParam("idNegocio") Integer idNegocio) {
        try {
            List<Cliente> clientesActivos = this.clienteRepository.find("activo = ?1 AND idNegocio = ?2", true, idNegocio).list();

            if (clientesActivos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron clientes").build();
            }

            List<ClienteDTO> clientesDtos = ClienteDTO.fromClientesDTO(clientesActivos);
            return Response.ok(clientesDtos).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los clientes")
                    .build();
        }
    }

    @GET
    @Path("/buscar-por-nombre/{nombre}")
    @Authenticated
    public Response listaClientesPorNombre(@PathParam("nombre") String nombre, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            String consulta = "FROM Cliente c WHERE (LOWER(c.nombres) LIKE CONCAT('%', :nombre, '%') OR LOWER(c.apellidos) LIKE CONCAT('%', :nombre, '%')) AND c.activo = true AND c.idNegocio = :idNegocio";
            List<Cliente> clientes = clienteRepository.list(consulta, Parameters.with("nombre", nombre.toLowerCase()).and("idNegocio", idNegocio).map());

            if (clientes.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron clientes con el nombre especificado")
                        .build();
            }

            List<ClienteDTO> clientesDTO = ClienteDTO.fromClientesDTO(clientes);
            return Response.ok(clientesDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los clientes")
                    .build();
        }
    }

    @GET
    @Path("/{identificacion}")
    @Authenticated
    public Response obtenerClientePorIdentificacion(@PathParam("identificacion") String identificacion, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            Optional<Cliente> clienteOpt = this.clienteRepository.find("identificacion = ?1 AND activo =?2 AND idNegocio = ?3", identificacion, true, idNegocio).singleResultOptional();
            if (clienteOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Cliente no encontrado").build();
            }
            ClienteDTO clienteDTO = ClienteDTO.from(clienteOpt.get());
            return Response.ok(clienteDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar el cliente")
                    .build();
        }
    }


    @PATCH
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response desactivarCliente(@PathParam("id") Integer id) {
        try {
            Optional<Cliente> clienteOptional = this.clienteRepository.findByIdOptional(id);

            if (clienteOptional.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontró el cliente")
                        .build();
            }
            Cliente cliente = clienteOptional.get();
            cliente.setActivo(false);
            return Response.ok("Cliente eliminado").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al desactivar el cliente")
                    .build();
        }
    }

    @POST
    @Authenticated
    @Transactional
    public Response registrarCliente(ClienteDTO obj) {
        try {
            Optional<Cliente> cliente = this.clienteRepository.find("identificacion = ?1 AND activo = true AND idNegocio = ?2", obj.getIdentificacion(), obj.getIdNegocio()).singleResultOptional();

            if (cliente.isPresent()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Ya existe un cliente con el mismo número de identificación")
                        .build();
            } else {
                Cliente ret = ClienteDTO.from(obj);
                ret.setActivo(true);
                this.clienteRepository.persist(ret);
                return Response.ok("Cliente registrado exitosamente").build();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al registrar el cliente")
                    .build();
        }
    }

    @PUT
    @Path("/{identificacion}")
    @Authenticated
    @Transactional
    public Response actualizarCliente(@PathParam("identificacion") String identificacion, ClienteDTO obj) {
        try {
            Optional<Cliente> clienteOptional = this.clienteRepository.find("identificacion = ?1 AND activo =?2 AND idNegocio = ?3", identificacion, true, obj.getIdNegocio()).singleResultOptional();
            if (clienteOptional.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Cliente no encontrado").build();
            }

            Cliente ret = clienteOptional.get();
            ret.setNombres(obj.getNombres());
            ret.setApellidos(obj.getApellidos());
            ret.setCorreo(obj.getCorreo());
            ret.setDireccion(obj.getDireccion());
            ret.setTelefono(obj.getTelefono());
            ret.setTipoId(TipoIdentificacion.valueOf(obj.getTipoId()));
            ret.setIdentificacion(obj.getIdentificacion());
            ret.setActivo(obj.isActivo());
            ret.setIdNegocio(obj.getIdNegocio());

            return Response.ok("Cliente actualizado exitosamente").build();

        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al actualizar el cliente")
                    .build();
        }
    }


}
