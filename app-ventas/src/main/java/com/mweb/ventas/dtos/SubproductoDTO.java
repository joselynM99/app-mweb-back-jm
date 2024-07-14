package com.mweb.ventas.dtos;


import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class SubproductoDTO {


	private String codigoBarras;
	private String nombre;
	private String descripcion;
	private BigDecimal costoPromedio;
	private BigDecimal precioSinImpuestos;
	private BigDecimal precioVenta;
	private Double stockActual;
	private boolean activo;
	private Integer impuesto;
	private Integer categoria;
	private Integer marca;
	private Integer cantidadRelacionada;
	private String producto;





}
