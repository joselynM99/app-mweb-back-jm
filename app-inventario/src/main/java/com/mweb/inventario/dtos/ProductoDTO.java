// ProductoDTO.java
package com.mweb.inventario.dtos;

import java.math.BigDecimal;
import com.mweb.inventario.db.Producto;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductoDTO {

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

    public static Producto from(ProductoDTO obj) {
        Producto ret = new Producto();
        ret.setDescripcion(obj.getDescripcion());
        ret.setNombre(obj.getNombre());
        ret.setCodigoBarras(obj.getCodigoBarras());
        ret.setCostoPromedio(obj.getCostoPromedio());
        ret.setPrecioSinImpuestos(obj.getPrecioSinImpuestos());
        ret.setPrecioVenta(obj.getPrecioVenta());
        ret.setStockActual(obj.getStockActual());
        ret.setActivo(obj.isActivo());
        ret.setIdNegocio(obj.getIdNegocio());
        return ret;
    }

    public static ProductoDTO from(Producto obj) {
        ProductoDTO ret = new ProductoDTO();
        ret.setDescripcion(obj.getDescripcion());
        ret.setNombre(obj.getNombre());
        ret.setCodigoBarras(obj.getCodigoBarras());
        ret.setCostoPromedio(obj.getCostoPromedio());
        ret.setPrecioSinImpuestos(obj.getPrecioSinImpuestos());
        ret.setPrecioVenta(obj.getPrecioVenta());
        ret.setStockActual(obj.getStockActual());
        ret.setActivo(obj.isActivo());
        ret.setIdNegocio(obj.getIdNegocio());

        if (obj.getCategoria() != null) {
            ret.setCategoria(obj.getCategoria().getId());
        }
        if (obj.getMarca() != null) {
            ret.setMarca(obj.getMarca().getId());
        }
        if (obj.getImpuesto() != null) {
            ret.setImpuesto(obj.getImpuesto().getId());
        }
        if (obj.getProveedor() != null) {
            ret.setProveedor(obj.getProveedor().getIdentificacion());
        }

        return ret;
    }
}