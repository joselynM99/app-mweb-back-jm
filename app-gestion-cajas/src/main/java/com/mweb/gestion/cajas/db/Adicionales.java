package com.mweb.gestion.cajas.db;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "adicionales")
public class Adicionales {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_adicionales")
    @SequenceGenerator(name = "seq_adicionales", sequenceName = "seq_adicionales", allocationSize = 1)
    @Column(name = "adic_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cc_id", nullable = false)
    private CuadreCaja cuadreCaja;

    @Column(name = "adic_valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "adic_fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "adic_motivo", nullable = false)
    private String motivo;

    @Column(name = "adic_activo", nullable = false)
    private boolean activo;

    @Column(name = "adic_tipo", nullable = false)
    private boolean tipo;


    @Column(name = "adic_pago_transferencia", nullable = false)
    private boolean pagoPorTransferencia;
}