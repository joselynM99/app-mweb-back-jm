package com.tesis.inventario.dtos;

import com.tesis.inventario.db.Producto;
import com.tesis.inventario.db.Subproducto;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

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
	private String proveedor;
	private Integer impuesto;
	private Integer categoria;
	private Integer marca;
	private Integer cantidadRelacionada;
	private String producto;

	public static Subproducto from(SubproductoDTO obj){
		Subproducto ret = new Subproducto();

		ret.setDescripcion(obj.getDescripcion());
		ret.setNombre(obj.getNombre());
		ret.setCodigoBarras(obj.getCodigoBarras());
		ret.setCostoPromedio(obj.getCostoPromedio());
		ret.setPrecioSinImpuestos(obj.getPrecioSinImpuestos());
		ret.setPrecioVenta(obj.getPrecioVenta());
		ret.setStockActual(obj.getStockActual());
		ret.setActivo(obj.isActivo());
		ret.setCantidadRelacionada(obj.getCantidadRelacionada());

		return ret;
	}

	public static SubproductoDTO from(Subproducto obj){

		SubproductoDTO ret = new SubproductoDTO();

		ret.setDescripcion(obj.getDescripcion());
		ret.setNombre(obj.getNombre());
		ret.setCodigoBarras(obj.getCodigoBarras());
		ret.setCostoPromedio(obj.getCostoPromedio());
		ret.setPrecioSinImpuestos(obj.getPrecioSinImpuestos());
		ret.setPrecioVenta(obj.getPrecioVenta());
		ret.setStockActual(obj.getStockActual());
		ret.setActivo(obj.isActivo());
		ret.setCantidadRelacionada(obj.getCantidadRelacionada());
		ret.setCategoria(obj.getCategoria().getId());
		ret.setMarca(obj.getProducto().getMarca().getId());
		ret.setImpuesto(obj.getImpuesto().getId());
		ret.setProveedor(obj.getProducto().getProveedor().getIdentificacion());
		ret.setProducto(obj.getProducto().getCodigoBarras());

		return ret;
	}




}
