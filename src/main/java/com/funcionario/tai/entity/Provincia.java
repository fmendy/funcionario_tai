package com.funcionario.tai.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Provincia")
public class Provincia implements Serializable {

	private static final long serialVersionUID = 711760904521940666L;

	public Provincia(Long id) {
		super();
		this.id = id;
	}

	@Id
	@Column(name = "ID", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDComunidadAutonoma")
	private ComunidadAutonoma comunidadAutonoma;

	@Column(name = "CodigoINE", length = 4)
	private String codigoINE;

	@Column(name = "Nombre", length = 60)
	private String nombre;

	@Column(name = "Activo")
	private boolean activo;

	@Column(name = "FechaCreacion")
	private Date fechaCreacion;

	@Column(name = "FechaModificacion")
	private Date fechaModificacion;

}
