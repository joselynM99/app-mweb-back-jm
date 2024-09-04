package com.mweb.gestion.cajas.dtos;

import com.mweb.gestion.cajas.db.Adicionales;
import com.mweb.gestion.cajas.db.CuadreCaja;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AdicionalesDTO {
    private Integer id;
    private Integer cuadreCajaId;
    private BigDecimal valor;
    private LocalDateTime fecha;
    private String motivo;
    private boolean activo;
    private boolean tipo;

    public static AdicionalesDTO from(Adicionales adicionales) {
        AdicionalesDTO dto = new AdicionalesDTO();
        dto.setId(adicionales.getId());
        dto.setCuadreCajaId(adicionales.getCuadreCaja().getId());
        dto.setValor(adicionales.getValor());
        dto.setFecha(adicionales.getFecha());
        dto.setMotivo(adicionales.getMotivo());
        dto.setActivo(adicionales.isActivo());
        dto.setTipo(adicionales.isTipo());
        return dto;
    }

    public static Adicionales from(AdicionalesDTO dto) {
        Adicionales adicionales = new Adicionales();
        adicionales.setId(dto.getId());
        // Assuming you have a method to fetch CuadreCaja by ID
        adicionales.setCuadreCaja(fetchCuadreCajaById(dto.getCuadreCajaId()));
        adicionales.setValor(dto.getValor());
        adicionales.setFecha(dto.getFecha());
        adicionales.setMotivo(dto.getMotivo());
        adicionales.setActivo(dto.isActivo());
        adicionales.setTipo(dto.isTipo());
        return adicionales;
    }

    private static CuadreCaja fetchCuadreCajaById(Integer id) {
        // Implement this method to fetch CuadreCaja by ID
        return new CuadreCaja();
    }
}