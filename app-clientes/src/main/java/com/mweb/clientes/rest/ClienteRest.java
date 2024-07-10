package com.mweb.clientes.rest;

import com.mweb.clientes.db.Cliente;
import com.mweb.clientes.db.enums.TipoIdentificacion;
import com.mweb.clientes.dtos.ClienteDTO;
import com.mweb.clientes.repo.ClienteRepository;
import io.quarkus.panache.common.Parameters;
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
@Transactional
public class ClienteRest {

    @Inject
    private ClienteRepository clienteRepository;

    @GET
    public Response listaClientes() {
        try {
            List<Cliente> clientesActivos = this.clienteRepository.find("activo = ?1", true).list();

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
    public Response listaClientesPorNombre(@PathParam("nombre") String nombre) {

        try {
            String consulta = "LOWER(nombre) LIKE CONCAT('%', :nombre, '%') AND activo = true";
            List<Cliente> clientes = this.clienteRepository.list(consulta, Parameters.with("nombre", nombre.toLowerCase()).map());

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
    public Response obtenerClientePorIdentificacion(@PathParam("identificacion") String identificacion) {
        try {
            Optional<Cliente> clienteOpt = this.clienteRepository.find("identificacion = ?1 AND activo =?2", identificacion, true).singleResultOptional();
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
    public Response registrarCliente(ClienteDTO obj) {
        try {

            Optional<Cliente> producto = this.clienteRepository.find("identificacion", obj.getIdentificacion()).singleResultOptional();

            if (producto.isPresent()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Ya existe un cliente con el mismo código de barras")
                        .build();
            } else {
                Cliente ret = ClienteDTO.from(obj);
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
    public Response actualizarProducto(@PathParam("identificacion") String identificacion, ClienteDTO obj) {
        try {
            Optional<Cliente> clienteOptional = this.clienteRepository.find("identificacion = ?1 AND activo =?2", identificacion, true).singleResultOptional();
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

            return Response.ok("Cliente actualizado exitosamente").build();

        } catch (Exception e) {
            e.printStackTrace(); // Puedes registrar el error para el seguimiento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al actualizar el cliente")
                    .build();
        }
    }


}
