// RolDTO.java
package com.mweb.negocios.dtos;

import com.mweb.negocios.db.Rol;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RolDTO {

    private Integer id;
    private String nombre;
    private String keycloakId;

    public static Rol from(RolDTO obj) {
        Rol rol = new Rol();
        rol.setId(obj.getId());
        rol.setNombre(obj.getNombre());
        rol.setKeycloakId(obj.getKeycloakId());
        return rol;
    }

    public static RolDTO from(Rol obj) {
        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(obj.getId());
        rolDTO.setNombre(obj.getNombre());
        rolDTO.setKeycloakId(obj.getKeycloakId());
        return rolDTO;
    }
}