package com.mweb.clientes.db;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Data
@Table(name = "abono")
public class Abono {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_abono")
	@SequenceGenerator(name = "seq_abono", sequenceName = "seq_abono", allocationSize = 1)
	@Column(name = "abon_id")
	private Integer id;
	
	@Column(name = "abon_monto")
	private BigDecimal monto;
	
	@Column(name = "abon_fecha")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn(name = "deud_id")
	private Deuda deuda;

}
