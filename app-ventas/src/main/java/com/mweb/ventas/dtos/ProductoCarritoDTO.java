package com.mweb.ventas.dtos;

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
	private  BigDecimal precioSinImpuestos;
	private Integer idNegocio;

	public static ProductoCarritoDTO from(ProductoDTO productoDTO) {
		ProductoCarritoDTO productoCarritoDTO = new ProductoCarritoDTO();
		productoCarritoDTO.setPrecioVenta(productoDTO.getPrecioVenta());
		productoCarritoDTO.setNombre(productoDTO.getNombre());
		productoCarritoDTO.setCodigoBarras(productoDTO.getCodigoBarras());
		productoCarritoDTO.setCantidad(1.00);
		productoCarritoDTO.setPrecioSinImpuestos(productoDTO.getPrecioSinImpuestos());
		productoCarritoDTO.setCostoPromedio(productoDTO.getCostoPromedio());
		productoCarritoDTO.setIdNegocio(productoDTO.getIdNegocio());
		return productoCarritoDTO;
	}

	public static ProductoCarritoDTO from(SubproductoDTO subproductoDTO) {
		ProductoCarritoDTO productoCarritoDTO = new ProductoCarritoDTO();
		productoCarritoDTO.setPrecioVenta(subproductoDTO.getPrecioVenta());
		productoCarritoDTO.setNombre(subproductoDTO.getNombre());
		productoCarritoDTO.setCodigoBarras(subproductoDTO.getCodigoBarras());
		productoCarritoDTO.setCantidad(1.00);
		productoCarritoDTO.setPrecioSinImpuestos(subproductoDTO.getPrecioSinImpuestos());
		productoCarritoDTO.setCostoPromedio(subproductoDTO.getCostoPromedio());
		productoCarritoDTO.setIdNegocio(subproductoDTO.getIdNegocio());
		return productoCarritoDTO;
	}

}
