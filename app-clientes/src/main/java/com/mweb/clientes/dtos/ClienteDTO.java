package com.mweb.clientes.dtos;

import com.mweb.clientes.db.Cliente;
import com.mweb.clientes.db.enums.TipoIdentificacion;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class ClienteDTO {

    private Integer id;
    private String tipoId;
    private String identificacion;
    private String apellidos;
    private String nombres;
    private String telefono;
    private String correo;
    private String direccion;
    private boolean activo;

    public static Cliente from(ClienteDTO obj) {
        Cliente cliente = new Cliente();
//        cliente.setId(obj.getId());
        cliente.setTipoId(TipoIdentificacion.valueOf(obj.getTipoId()));
        cliente.setIdentificacion(obj.getIdentificacion());
        cliente.setApellidos(obj.getApellidos());
        cliente.setNombres(obj.getNombres());
        cliente.setTelefono(obj.getTelefono());
        cliente.setCorreo(obj.getCorreo());
        cliente.setDireccion(obj.getDireccion());
        cliente.setActivo(obj.isActivo());
        return cliente;
    }

    public static ClienteDTO from(Cliente obj) {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setId(obj.getId());
        cliente.setTipoId(String.valueOf(TipoIdentificacion.valueOf(obj.getTipoId().name())));
        cliente.setIdentificacion(obj.getIdentificacion());
        cliente.setApellidos(obj.getApellidos());
        cliente.setNombres(obj.getNombres());
        cliente.setTelefono(obj.getTelefono());
        cliente.setCorreo(obj.getCorreo());
        cliente.setDireccion(obj.getDireccion());
        cliente.setActivo(obj.isActivo());

        return cliente;
    }

    public static List<ClienteDTO> fromClientesDTO(List<Cliente> clientees) {
        List<ClienteDTO> dtos = new ArrayList<>();
        for (Cliente cliente : clientees) {
            ClienteDTO p = from(cliente);
            p.setId(cliente.getId());
            dtos.add(p);
        }
        return dtos;
    }

    public static List<Cliente> fromClientes(List<ClienteDTO> dtos) {
        List<Cliente> clientees = new ArrayList<>();
        for (ClienteDTO cliente : dtos) {
            Cliente p = from(cliente);
            p.setId(cliente.getId());
            clientees.add(p);
        }
        return clientees;
    }

}
