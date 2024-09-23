
package com.mweb.transacciones.db;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "detalle_venta")
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle_venta")
	@SequenceGenerator(name = "seq_detalle_venta", sequenceName = "seq_detalle_venta", allocationSize = 1)
	@Column(name = "deve_id")
	private Integer id;

	@Column(name = "deve_cantidad", nullable = false)
	private Double cantidad;

	@Column(name = "deve_total", nullable = false)
	private BigDecimal total;

	@ManyToOne
	@JoinColumn(name = "vent_id", nullable = false)
	private Venta venta;

	@Column(name="prod_codigo_barras")
	private String productoCodigo;

	@Column(name = "supr_codigo_barras")
	private String subProductoCodigo;


}
