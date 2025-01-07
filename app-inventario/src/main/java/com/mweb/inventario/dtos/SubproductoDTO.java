package com.mweb.inventario.dtos;

import com.mweb.inventario.db.Subproducto;
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
	private Integer cantidadRelacionada;
	private String producto;
	private Integer idNegocio;

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
		ret.setIdNegocio(obj.getIdNegocio());

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
		if (obj.getCategoria() != null) {
			ret.setCategoria(obj.getCategoria().getId());
		}
		ret.setImpuesto(obj.getImpuesto().getId());
		ret.setProducto(obj.getProducto().getCodigoBarras());
		ret.setIdNegocio(obj.getIdNegocio());
		return ret;
	}

	public static List<SubproductoDTO> fromSubproductos(List<Subproducto> subproductos) {
		List<SubproductoDTO> dtos = new ArrayList<>();
		for (Subproducto subproducto : subproductos) {
			dtos.add(from(subproducto));
		}
		return dtos;
	}


}
