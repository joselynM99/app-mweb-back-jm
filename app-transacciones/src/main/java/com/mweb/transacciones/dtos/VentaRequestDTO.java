package com.mweb.transacciones.dtos;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
	private Integer idCuadreCaja;
	private Integer idNegocio;
	private Integer numeroReferencia;
	private LocalDateTime fecha;

}
