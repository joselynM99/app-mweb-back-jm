package com.mweb.transacciones.db;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "venta")
@Data
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_venta")
    @SequenceGenerator(name = "seq_venta", sequenceName = "seq_venta", allocationSize = 1)
    @Column(name = "vent_id")
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "vent_fecha")
    private LocalDateTime fecha;

    @Column(name = "vent_total")
    private BigDecimal total;

    @Column(name = "vent_pago_transferencia")
    private Boolean pagoTransferencia;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalles;

    @ManyToOne
    @JoinColumn(name = "clie_id")
    private Cliente cliente;

    @Column(name = "vent_activo")
    private Boolean activo;

    @Column(name = "vent_numero_referencia")
    private Integer numeroReferencia;

    @Column(name = "vent_id_cuadre_caja")
    private Integer idCuadreCaja;

    @Column(name = "vent_id_negocio")
    private Integer idNegocio;

    @Column(name = "vent_username")
    private String username;
}