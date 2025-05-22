package com.mweb.negocios.db;

import com.mweb.negocios.db.enums.TipoIdentificacion;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
    @Column(name = "usua_id")
    private Integer id;

    @Column(name = "usua_keycloak_id", unique = true, nullable = false)
    private String keycloakId;

    @Column(name = "usua_nombre_usuario", unique = true)
    private String nombreUsuario;

    @Column(name = "usua_correo", unique = true, nullable = false)
    private String correo;

    @Column(name = "usua_nombre", nullable = false)
    private String nombre;

    @Column(name = "usua_apellido", nullable = false)
    private String apellido;

    @Column(name = "usua_activo", nullable = false)
    private boolean activo;

    @Enumerated(EnumType.STRING)
    @Column(name = "usua_tipo_identificacion", nullable = false)
    private TipoIdentificacion tipoIdentificacion;

    @Column(name = "usua_identificacion", nullable = false)
    private String identificacion;

    @Column(name = "usua_telefono", nullable = false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "usua_negocio_id")
    private Negocio negocio;

    @ManyToOne
    @JoinColumn(name = "usua_rol_id", nullable = true)
    private Rol rol;

}