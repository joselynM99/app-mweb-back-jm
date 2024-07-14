package com.mweb.ventas.dtos;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
public class ProductoVentaDTO{

	private String codigoBarras;
	private String nombre;
	private BigDecimal precioVenta;
	

}
