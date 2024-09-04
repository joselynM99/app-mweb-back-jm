package com.mweb.inventario.db;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "marca")
@Data
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca")
    @SequenceGenerator(name = "seq_marca", sequenceName = "seq_marca", allocationSize = 1)
    @Column(name = "marc_id")
    private Integer id;

    @Column(name = "marc_nombre", nullable = false)
    private String nombre;

    @Column(name = "marc_activo")
    private boolean activo;

    @Column(name = "marc_id_negocio")
    private Integer idNegocio;

    @OneToMany(mappedBy = "marca", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Producto> productos;




}
