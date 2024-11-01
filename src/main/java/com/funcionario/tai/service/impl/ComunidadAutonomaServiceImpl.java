package com.funcionario.tai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.funcionario.tai.entity.ComunidadAutonoma;
import com.funcionario.tai.model.ComunidadAutonomaForm;
import com.funcionario.tai.model.filter.ComunidadAutonomaFilter;
import com.funcionario.tai.model.specifications.ComunidadAutonomaSpecifications;
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

	@Override
	public Page<ComunidadAutonomaForm> getPageSearch(ComunidadAutonomaFilter filter, Pageable pageable) {
		System.out.println(comunidadAutonomaRepository.findAll().size());
		Page<ComunidadAutonoma> page = comunidadAutonomaRepository
				.findAll(ComunidadAutonomaSpecifications.filter(filter), pageable);

		return ComunidadAutonomaUtil.pageComunidadAutonomaToPageForm(page);
	}

}
