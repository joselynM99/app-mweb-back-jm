package com.mweb.clientes.rest;

import com.mweb.clientes.db.Cliente;
import com.mweb.clientes.dtos.ClienteDTO;
import com.mweb.clientes.repo.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class ClienteRest {

    @Inject
    private ClienteRepository clienteRepository;

    @GET
    //@PermitAll
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
                    .entity("Ha ocurrido un error al obtener los productos")
                    .build();
        }


    }





}
