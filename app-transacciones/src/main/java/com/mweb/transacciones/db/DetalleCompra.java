package com.mweb.transacciones.db;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "detalle_compra")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle_compra")
    @SequenceGenerator(name = "seq_detalle_compra", sequenceName = "seq_detalle_compra", allocationSize = 1)
    @Column(name = "deco_id")
    private Integer id;

    @Column(name = "deco_cantidad", nullable = false)
    private Double cantidad;

    @Column(name = "deco_total", nullable = false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "comp_id", nullable = false)
    private Compra compra;

    @Column(name = "prod_codigo_barras")
    private String productoCodigo;

    @Column(name = "supr_codigo_barras")
    private String subProductoCodigo;
}