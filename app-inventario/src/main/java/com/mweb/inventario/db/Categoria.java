package com.mweb.inventario.db;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categoria")
@Data
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria")
	@SequenceGenerator(name = "seq_categoria", sequenceName = "seq_categoria", allocationSize = 1)
	@Column(name = "cate_id")
	private Integer id;

	@Column(name = "cate_nombre")
	private String nombre;
	
	@Column(name = "cate_descripcion")
	private String descripcion;

	@Column(name = "cate_activo")
	private boolean activo;

	@Column(name = "cate_id_negocio")
	private Integer idNegocio;
	
	@OneToMany(mappedBy = "categoria", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Producto> productos;
	
	@OneToMany(mappedBy = "categoria", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Subproducto> subproductos;


	
}
