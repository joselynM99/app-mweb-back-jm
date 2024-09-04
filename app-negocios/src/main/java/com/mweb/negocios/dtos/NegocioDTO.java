package com.mweb.negocios.dtos;

import com.mweb.negocios.db.Negocio;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NegocioDTO {

    private Integer id;
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private String razonSocial;
    private boolean activo;
    // NegocioDTO.java
    private String ruc;

    public static Negocio from(NegocioDTO obj) {
        Negocio negocio = new Negocio();
        negocio.setId(obj.getId());
        negocio.setNombreComercial(obj.getNombreComercial());
        negocio.setDireccion(obj.getDireccion());
        negocio.setTelefono(obj.getTelefono());
        negocio.setRazonSocial(obj.getRazonSocial());
        negocio.setActivo(obj.isActivo());
        negocio.setRuc(obj.getRuc());
        return negocio;
    }

    public static NegocioDTO from(Negocio obj) {
        NegocioDTO negocioDTO = new NegocioDTO();
        negocioDTO.setId(obj.getId());
        negocioDTO.setNombreComercial(obj.getNombreComercial());
        negocioDTO.setDireccion(obj.getDireccion());
        negocioDTO.setTelefono(obj.getTelefono());
        negocioDTO.setRazonSocial(obj.getRazonSocial());
        negocioDTO.setActivo(obj.isActivo());
        negocioDTO.setRuc(obj.getRuc());
        return negocioDTO;
    }
}