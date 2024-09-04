package com.mweb.inventario.dtos;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MarcaDTO {

    private Integer id;
    private String nombre;
    private Integer idNegocio;
    private boolean activo;
}
