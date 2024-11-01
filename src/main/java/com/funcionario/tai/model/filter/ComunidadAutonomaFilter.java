package com.funcionario.tai.model.filter;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComunidadAutonomaFilter implements Serializable {

	private static final long serialVersionUID = 2370332746103254728L;

	private String nombre;
}
