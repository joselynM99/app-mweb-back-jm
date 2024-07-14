package com.mweb.inventario.dtos;

import com.mweb.inventario.db.Producto;
import com.mweb.inventario.db.Subproducto;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class ProductoListaDTO {


	private Integer id;
	private String codigoBarras;
	private String nombre;
	private String descripcion;
	private BigDecimal costoPromedio;
	private BigDecimal precioSinImpuestos;
	private BigDecimal precioVenta;
	private Double stockActual;
	private boolean activo;
	private Integer cantidadRelacionada;


	public static Producto from(ProductoListaDTO obj){
		Producto ret = new Producto();

		ret.setId(obj.getId());
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

	public static ProductoListaDTO from(Producto obj){

		ProductoListaDTO ret = new ProductoListaDTO();

		ret.setId(obj.getId());
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


	public static ProductoListaDTO from(Subproducto obj){

		ProductoListaDTO ret = new ProductoListaDTO();

		ret.setId(obj.getId());
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

	public static List<ProductoListaDTO> fromProductos(List<Producto> productos) {
		List<ProductoListaDTO> dtos = new ArrayList<>();
		for (Producto producto : productos) {
			dtos.add(from(producto));
		}
		return dtos;
	}

	public static List<ProductoListaDTO> fromSubproductos(List<Subproducto> subproductos) {
		List<ProductoListaDTO> dtos = new ArrayList<>();
		for (Subproducto subproducto : subproductos) {
			dtos.add(from(subproducto));
		}
		return dtos;
	}
}
