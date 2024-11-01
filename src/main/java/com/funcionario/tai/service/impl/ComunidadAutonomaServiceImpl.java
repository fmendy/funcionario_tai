package com.funcionario.tai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funcionario.tai.model.ComunidadAutonomaForm;
import com.funcionario.tai.repository.ComunidadAutonomaRepository;
import com.funcionario.tai.service.ComunidadAutonomaService;
import com.funcionario.tai.utility.ComunidadAutonomaUtil;

@Service
public class ComunidadAutonomaServiceImpl implements ComunidadAutonomaService {

	@Autowired
	private ComunidadAutonomaRepository comunidadAutonomaRepository;

	@Override
	public List<ComunidadAutonomaForm> getListForm() {

		return ComunidadAutonomaUtil
				.listComunidadAutonomaToListForm(comunidadAutonomaRepository.findByActivoTrueOrderByNombre());
	}

}
