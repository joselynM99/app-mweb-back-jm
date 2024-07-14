package com.mweb.clientes.dtos;

import com.mweb.clientes.db.DetalleDeuda;
import com.mweb.clientes.db.Deuda;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
@Data
@ToString
public class DetalleDeudaDTO {
	private Double cantidad;
	private String codigoBarras;
	private String nombre;
	private BigDecimal precioVenta;
	private BigDecimal subtotal;


}
