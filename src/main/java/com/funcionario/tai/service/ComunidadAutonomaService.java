package com.funcionario.tai.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.funcionario.tai.model.ComunidadAutonomaForm;
import com.funcionario.tai.model.filter.ComunidadAutonomaFilter;

public interface ComunidadAutonomaService {

	public List<ComunidadAutonomaForm> getListForm();

	Page<ComunidadAutonomaForm> getPageSearch(ComunidadAutonomaFilter filter, Pageable pageable);
}
