package com.mweb.ventas.dtos;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
public class VentaRequestDTO {

	private List<ProductoCarritoDTO> detalles;
	private DescuentoDTO descuento;
	private String cliente;
	private String username;
	private boolean pagoTransferencia;
	private BigDecimal total;

}
