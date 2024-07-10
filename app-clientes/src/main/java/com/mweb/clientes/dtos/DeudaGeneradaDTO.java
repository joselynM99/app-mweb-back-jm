package com.mweb.clientes.dtos;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
public class DeudaGeneradaDTO {

    private List<ProductoCarritoDTO> detalles;
    private String cliente;
    private BigDecimal total;
    private List<AbonoDTO> abonos;
}
