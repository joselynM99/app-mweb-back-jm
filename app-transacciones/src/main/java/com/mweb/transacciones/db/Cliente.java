package com.mweb.transacciones.db;

import java.util.List;

import com.mweb.transacciones.db.enums.TipoIdentificacion;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    @SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1)
    @Column(name = "clie_id")
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "clie_tipo_id", nullable = false)
    private TipoIdentificacion tipoId;

    @Column(name = "clie_identificacion", nullable = false)
    private String identificacion;

    @Column(name = "clie_apellidos", nullable = false)
    private String apellidos;

    @Column(name = "clie_nombres", nullable = false)
    private String nombres;

    @Column(name = "clie_telefono")
    private String telefono;

    @Column(name = "clie_correo")
    private String correo;

    @Column(name = "clie_direccion")
    private String direccion;

    @Column(name = "clie_activo", nullable = false)
    private boolean activo;

    @Column(name = "clie_id_negocio", nullable = false)
    private Integer idNegocio;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Deuda> deudas;


}
