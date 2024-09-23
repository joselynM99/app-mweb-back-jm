package com.mweb.gestion.cajas.db;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "cuadre_caja")
public class CuadreCaja {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuadre_caja")
    @SequenceGenerator(name = "seq_cuadre_caja", sequenceName = "seq_cuadre_caja", allocationSize = 1)
    @Column(name = "cc_id")
    private Integer id;

    @Column(name = "cc_usuario", nullable = false)
    private String usuario;

    @Column(name = "cc_id_negocio", nullable = false)
    private Integer idNegocio;

    @Column(name = "cc_fecha_apertura", nullable = false)
    private LocalDateTime fechaApertura;

    @Column(name = "cc_fecha_cierre")
    private LocalDateTime fechaCierre;

    @Column(name = "cc_total_ingresos_efectivo")
    private BigDecimal totalIngresosEfectivo;

    @Column(name = "cc_total_ingresos_transferencia")
    private BigDecimal totalIngresosTransferencia;

    @Column(name = "cc_total_gastos_efectivo")
    private BigDecimal totalGastosEfectivo;

    @Column(name = "cc_total_gastos_transferencia")
    private BigDecimal totalGastosTransferencia;

    @Column(name = "cc_saldo_final_efectivo")
    private BigDecimal saldoFinalEfectivo;

    @Column(name = "cc_saldo_final_transferencia")
    private BigDecimal saldoFinalTransferencia;

    @Column(name = "cc_valor_contable")
    private BigDecimal valorContable;

    @Column(name = "cc_diferencia")
    private BigDecimal diferencia;

    @Column(name = "cc_valor_cierre")
    private BigDecimal valorCierre;

    @Column(name = "cc_valor_apertura", nullable = false)
    private BigDecimal valorApertura;

    @Column(name = "cc_estado", nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "cuadreCaja", cascade = CascadeType.ALL)
    private List<Adicionales> adicionales;

    @ManyToOne
    @JoinColumn(name = "caja_id", nullable = false)
    private Caja caja;
}