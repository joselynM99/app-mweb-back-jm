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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "compra")
@Data
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_compra")
    @SequenceGenerator(name = "seq_compra", sequenceName = "seq_compra", allocationSize = 1)
    @Column(name = "comp_id")
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "comp_fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "comp_total", nullable = false)
    private BigDecimal total;

    @Column(name = "comp_pago_transferencia", nullable = false)
    private Boolean pagoTransferencia;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<DetalleCompra> detalles;

    @Column(name = "prov_identificacion")
    private String proveedorIdentificacion;

    @Column(name = "comp_activo", nullable = false)
    private Boolean activo;

    @Column(name = "comp_numero_referencia", nullable = false)
    private Integer numeroReferencia;

    @Column(name = "comp_id_cuadre_caja", nullable = false)
    private Integer idCuadreCaja;

    @Column(name = "comp_id_negocio", nullable = false)
    private Integer idNegocio;

    @Column(name = "comp_username", nullable = false)
    private String username;
}