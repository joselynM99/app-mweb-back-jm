package com.mweb.inventario.db;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "subproducto")
public class Subproducto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sub_producto")
    @SequenceGenerator(name = "seq_sub_producto", sequenceName = "seq_sub_producto", allocationSize = 1)
    @Column(name = "supr_id")
    private Integer id;

    @Column(name = "supr_codigo_barras", nullable = false)
    private String codigoBarras;

    @Column(name = "supr_nombre", nullable = false)
    private String nombre;

    @Column(name = "supr_descripcion")
    private String descripcion;

    @Column(name = "supr_cantidad_relacionada", nullable = false)
    private Integer cantidadRelacionada;

    @Column(name = "supr_costo_promedio", nullable = false)
    private BigDecimal costoPromedio;

    @Column(name = "subpr_precio_sin_impuestos", nullable = false)
    private BigDecimal precioSinImpuestos;

    @Column(name = "supr_precio_venta", nullable = false)
    private BigDecimal precioVenta;

    @Column(name = "supr_stock_actual",nullable = false)
    private Double stockActual;

    @Column(name = "supr_id_negocio",nullable = false)
    private Integer idNegocio;

    @Column(name = "supr_activo")
    private boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "impu_id")
    private Impuesto impuesto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_id", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cate_id")
    private Categoria categoria;


}
