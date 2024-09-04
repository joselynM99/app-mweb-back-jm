// File: app-compras/src/main/java/com/mweb/compras/dtos/CompraResumenDTO.java
package com.mweb.gestion.cajas.dtos;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString
public class CompraResumenDTO {
    private LocalDateTime fecha;
    private BigDecimal total;
    private Integer numeroReferencia;
    private Boolean pagoTransferencia;
}