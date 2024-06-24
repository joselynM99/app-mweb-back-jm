package com.tesis.inventario.db;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "producto")
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_producto")
    @SequenceGenerator(name = "seq_producto", sequenceName = "seq_producto", allocationSize = 1)
    @Column(name = "prod_id")
    private Integer id;

    @Column(name = "prod_codigo_barras", unique = true, nullable = false)
    private String codigoBarras;

    @Column(name = "prod_nombre", nullable = false)
    private String nombre;

    @Column(name = "prod_descripcion")
    private String descripcion;

    @Column(name = "prod_costo_promedio")
    private BigDecimal costoPromedio;

    @Column(name = "prod_precio_sin_impuestos")
    private BigDecimal precioSinImpuestos;

    @Column(name = "prod_precio_venta")
    private BigDecimal precioVenta;

    @Column(name = "prod_stock_actual")
    private Double stockActual;

    @Column(name = "prod_activo")
    private boolean activo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cate_id")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marc_id")
    private Marca marca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prov_id")
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "impu_id")
    private Impuesto impuesto;

    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Subproducto> subproductos;
}
