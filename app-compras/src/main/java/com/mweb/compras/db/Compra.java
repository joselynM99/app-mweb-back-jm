package com.mweb.compras.db;

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
    @Column(name = "comp_fecha")
    private LocalDateTime fecha;

    @Column(name = "comp_total")
    private BigDecimal total;

    @Column(name = "comp_pago_transferencia")
    private Boolean pagoTransferencia;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<DetalleCompra> detalles;

    @Column(name = "prov_identificacion")
    private String proveedorIdentificacion;

    @Column(name = "comp_activo")
    private Boolean activo;

    @Column(name = "comp_numero_referencia")
    private Integer numeroReferencia;

    @Column(name = "comp_id_cuadre_caja")
    private Integer idCuadreCaja;

    @Column(name = "comp_id_negocio")
    private Integer idNegocio;

    @Column(name = "comp_username")
    private String username;
}