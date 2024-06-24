package com.tesis.inventario.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.tesis.inventario.db.Producto;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.ToString;

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

	public static Producto from(ProductoDTO obj){
		Producto ret = new Producto();

		ret.setDescripcion(obj.getDescripcion());
		ret.setNombre(obj.getNombre());
		ret.setCodigoBarras(obj.getCodigoBarras());
		ret.setCostoPromedio(obj.getCostoPromedio());
		ret.setPrecioSinImpuestos(obj.getPrecioSinImpuestos());
		ret.setPrecioVenta(obj.getPrecioVenta());
		ret.setStockActual(obj.getStockActual());
		ret.setActivo(obj.isActivo());

		return ret;
	}

	public static ProductoDTO from(Producto obj){

		ProductoDTO ret = new ProductoDTO();

		ret.setDescripcion(obj.getDescripcion());
		ret.setNombre(obj.getNombre());
		ret.setCodigoBarras(obj.getCodigoBarras());
		ret.setCostoPromedio(obj.getCostoPromedio());
		ret.setPrecioSinImpuestos(obj.getPrecioSinImpuestos());
		ret.setPrecioVenta(obj.getPrecioVenta());
		ret.setStockActual(obj.getStockActual());
		ret.setActivo(obj.isActivo());
		ret.setCategoria(obj.getCategoria().getId());
		ret.setMarca(obj.getMarca().getId());
		ret.setImpuesto(obj.getImpuesto().getId());
		ret.setProveedor(obj.getProveedor().getIdentificacion());

		return ret;
	}




}
