package com.mweb.inventario.db;

import com.mweb.inventario.db.enums.TipoIdentificacion;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "proveedor")
@Data
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_proveedor")
    @SequenceGenerator(name = "seq_proveedor", sequenceName = "seq_proveedor", allocationSize = 1)
    @Column(name = "prov_id")
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "prov_tipo_id", nullable = false)
    private TipoIdentificacion tipoIdentificacion;

    @Column(name = "prov_identificacion", nullable = false)
    private String identificacion;

    @Column(name = "prov_razon_social", nullable = false)
    private String razonSocial;

    @Column(name = "prov_nombre_comercial", nullable = false)
    private String nombreComercial;

    @Column(name = "prov_telefono")
    private String telefono;

    @Column(name = "prov_correo")
    private String correo;

    @Column(name = "prov_direccion")
    private String direccion;

    @Column(name = "prov_activo", nullable = false)
    private boolean activo;

    @Column(name = "prov_id_negocio", nullable = false)
    private Integer idNegocio;

    @OneToMany(mappedBy = "proveedor", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Producto> productos;

}
