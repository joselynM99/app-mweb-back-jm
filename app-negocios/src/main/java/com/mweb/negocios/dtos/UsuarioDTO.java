// UsuarioDTO.java
package com.mweb.negocios.dtos;

import com.mweb.negocios.db.Usuario;
import com.mweb.negocios.db.enums.TipoIdentificacion;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UsuarioDTO {

    private Integer id;
    private String keycloakId;
    private String nombreUsuario;
    private String correo;
    private String nombre;
    private String apellido;
    private boolean activo;
    private String tipoIdentificacion;
    private String identificacion;
    private String telefono;
    private String password;
    private Integer rolId;
    private Integer negocioId; // New attribute

    public static Usuario from(UsuarioDTO obj) {
        Usuario usuario = new Usuario();
        usuario.setId(obj.getId());
        usuario.setKeycloakId(obj.getKeycloakId());
        usuario.setNombreUsuario(obj.getNombreUsuario());
        usuario.setCorreo(obj.getCorreo());
        usuario.setNombre(obj.getNombre());
        usuario.setApellido(obj.getApellido());
        usuario.setActivo(obj.isActivo());
        usuario.setTipoIdentificacion(TipoIdentificacion.valueOf(obj.getTipoIdentificacion()));
        usuario.setIdentificacion(obj.getIdentificacion());
        usuario.setTelefono(obj.getTelefono());
        // Password should be handled securely and not directly set here
        return usuario;
    }

    public static UsuarioDTO from(Usuario obj) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(obj.getId());
        usuarioDTO.setKeycloakId(obj.getKeycloakId());
        usuarioDTO.setNombreUsuario(obj.getNombreUsuario());
        usuarioDTO.setCorreo(obj.getCorreo());
        usuarioDTO.setNombre(obj.getNombre());
        usuarioDTO.setApellido(obj.getApellido());
        usuarioDTO.setActivo(obj.isActivo());
        usuarioDTO.setTipoIdentificacion(obj.getTipoIdentificacion().name());
        usuarioDTO.setIdentificacion(obj.getIdentificacion());
        usuarioDTO.setTelefono(obj.getTelefono());
        // Password should be handled securely and not directly set here
        if (obj.getRol() != null) {
            usuarioDTO.setRolId(obj.getRol().getId());
        }
        if (obj.getNegocio() != null) {
            usuarioDTO.setNegocioId(obj.getNegocio().getId());
        }
        return usuarioDTO;
    }
}