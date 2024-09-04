package com.mweb.gestion.cajas.dtos;

import com.mweb.gestion.cajas.db.Caja;
import lombok.Data;

@Data
public class CajaDTO {
    private Integer id;
    private String nombre;

    public static CajaDTO from(Caja caja) {
        CajaDTO dto = new CajaDTO();
        dto.setId(caja.getId());
        dto.setNombre(caja.getNombre());
        return dto;
    }

    public static Caja from(CajaDTO dto) {
        Caja caja = new Caja();
        caja.setId(dto.getId());
        caja.setNombre(dto.getNombre());
        return caja;
    }
}