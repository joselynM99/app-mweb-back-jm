package com.mweb.clientes.dtos;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
@Data
@ToString
public class ProductoCarritoDTO {
	private Double cantidad;
	private String codigoBarras;
	private String nombre;
	private BigDecimal precioVenta;
	private BigDecimal subtotal;
	private BigDecimal costoPromedio;
	

}
