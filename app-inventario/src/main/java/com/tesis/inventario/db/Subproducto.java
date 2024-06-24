package com.tesis.inventario.db;

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

    @Column(name = "supr_codigo_barras", unique = true, nullable = false)
    private String codigoBarras;

    @Column(name = "supr_nombre", nullable = false)
    private String nombre;

    @Column(name = "supr_descripcion")
    private String descripcion;

    @Column(name = "supr_cantidad_relacionada")
    private Integer cantidadRelacionada;

    @Column(name = "supr_costo_promedio")
    private BigDecimal costoPromedio;

    @Column(name = "subpr_precio_sin_impuestos")
    private BigDecimal precioSinImpuestos;

    @Column(name = "supr_precio_venta")
    private BigDecimal precioVenta;

    @Column(name = "supr_stock_actual")
    private Double stockActual;

    @Column(name = "supr_activo")
    private boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "impu_id")
    private Impuesto impuesto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_id")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cate_id")
    private Categoria categoria;


}
