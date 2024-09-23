package com.mweb.gestion.cajas.dtos;

import com.mweb.gestion.cajas.db.Caja;
import lombok.Data;

@Data
public class CajaDTO {
    private Integer id;
    private String nombre;
    private Integer idNegocio;

    public static CajaDTO from(Caja caja) {
        CajaDTO dto = new CajaDTO();
        dto.setId(caja.getId());
        dto.setNombre(caja.getNombre());
        dto.setIdNegocio(caja.getIdNegocio());
        return dto;
    }

    public static Caja from(CajaDTO dto) {
        Caja caja = new Caja();
        caja.setId(dto.getId());
        caja.setNombre(dto.getNombre());
        caja.setIdNegocio(dto.getIdNegocio());
        return caja;
    }
}