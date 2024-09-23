package com.mweb.gestion.cajas.db;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "caja")
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_caja")
    @SequenceGenerator(name = "seq_caja", sequenceName = "seq_caja", allocationSize = 1)
    @Column(name = "caja_id")
    private Integer id;

    @Column(name = "caja_nombre", nullable = false)
    private String nombre;

    @Column(name = "caja_id_negocio", nullable = false)
    private Integer idNegocio;

    @OneToMany(mappedBy = "caja", cascade = CascadeType.ALL)
    private List<CuadreCaja> cuadreCajas;

    @Column(name = "caja_activo", nullable = false)
    private boolean activo;
}