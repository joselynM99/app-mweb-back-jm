package com.mweb.clientes.db;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "deuda")
public class Deuda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_deuda")
	@SequenceGenerator(name = "seq_deuda", sequenceName = "seq_deuda", allocationSize = 1)
	@Column(name = "deud_id")
	private Integer id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(name = "deud_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "deud_total")
	private BigDecimal total;
	
	@Column(name = "deud_estado")
	private Boolean estado;

	@OneToMany(mappedBy = "deuda", cascade = CascadeType.ALL)
	private List<DetalleDeuda> detalles;
	
	@OneToMany(mappedBy = "deuda", cascade = CascadeType.ALL)
	private List<Abono> abonos;
	
	@ManyToOne
	@JoinColumn(name = "clie_id")
	private Cliente cliente;


}
