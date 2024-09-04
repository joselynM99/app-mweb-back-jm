// Rol.java
package com.mweb.negocios.db;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rol")
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rol")
    @SequenceGenerator(name = "seq_rol", sequenceName = "seq_rol", allocationSize = 1)
    @Column(name = "rol_id")
    private Integer id;

    @Column(name = "rol_nombre", nullable = false)
    private String nombre;

    @Column(name = "rol_keycloak_id", unique = true, nullable = false)
    private String keycloakId;
}