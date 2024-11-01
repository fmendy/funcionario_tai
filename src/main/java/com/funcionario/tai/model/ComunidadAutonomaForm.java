package com.funcionario.tai.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComunidadAutonomaForm implements Serializable {

	private static final long serialVersionUID = 6516212526775984540L;
	
	private Long id;

	private String nombre;
}
