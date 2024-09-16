package com.mweb.transacciones.dtos;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
public class CompraRequestDTO {

	private List<ProductoCarritoDTO> detalles;
	private String proveedor;
	private String username;
	private boolean pagoTransferencia;
	private BigDecimal total;
	private Integer idCuadreCaja;
	private Integer idNegocio;

}
