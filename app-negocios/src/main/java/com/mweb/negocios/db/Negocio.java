package com.mweb.negocios.db;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "negocio")
@Data
public class Negocio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_negocio")
    @SequenceGenerator(name = "seq_negocio", sequenceName = "seq_negocio", allocationSize = 1)
    @Column(name = "nego_id")
    private Integer id;

    @Column(name = "nego_nombre_comercial", unique = true, nullable = false)
    private String nombreComercial;

    @Column(name = "nego_direccion", nullable = false)
    private String direccion;

    @Column(name = "nego_telefono", nullable = false)
    private String telefono;

    @Column(name = "nego_razon_social", unique = true, nullable = false)
    private String razonSocial;

    @Column(name = "nego_activo" )
    private boolean activo;


    @Column(name = "nego_ruc", nullable = false, unique = true)
    private String ruc;

    @OneToMany(mappedBy = "negocio", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Usuario> usuarios;

}