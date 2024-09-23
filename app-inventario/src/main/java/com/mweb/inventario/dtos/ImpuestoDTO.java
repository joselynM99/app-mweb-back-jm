package com.mweb.inventario.dtos;

import com.mweb.inventario.db.enums.TipoImpuesto;
import lombok.Data;

@Data
public class ImpuestoDTO {
    private Integer id;
    private Double valor;
    private TipoImpuesto tipoImpuesto;
    private boolean activo;
}