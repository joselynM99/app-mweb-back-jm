package com.mweb.inventario.db;

import java.util.List;
import com.mweb.inventario.db.enums.TipoImpuesto;
import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "impuesto")
@Data
public class Impuesto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_impuesto")
	@SequenceGenerator(name = "seq_impuesto", sequenceName = "seq_impuesto", allocationSize = 1)
	@Column(name = "impu_id")
	private Integer id;
	
	@Column(name = "impu_valor", nullable = false)
	private Double valor;
	
	@Column(name = "impu_tipo_impuesto", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private TipoImpuesto tipoImpuesto;

	@Column(name = "impu_activo", nullable = false)
	private boolean activo;
	
	@OneToMany(mappedBy = "impuesto", cascade = CascadeType.ALL)
	private List<Producto> productos;
	
	@OneToMany(mappedBy = "impuesto", cascade = CascadeType.ALL)
	private List<Subproducto> subproductos;


}
