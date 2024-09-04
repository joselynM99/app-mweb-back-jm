package com.mweb.inventario.dtos;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CategoriaDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer idNegocio;
    private boolean activo;
}
