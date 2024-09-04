package com.mweb.compras.dtos;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class ProductoDTO  {


	private String codigoBarras;
	private String nombre;
	private String descripcion;
	private BigDecimal costoPromedio;
	private BigDecimal precioSinImpuestos;
	private BigDecimal precioVenta;
	private Double stockActual;
	private boolean activo;
	private String proveedor;
	private Integer impuesto;
	private Integer categoria;
	private Integer marca;
	private Integer idNegocio;




}
