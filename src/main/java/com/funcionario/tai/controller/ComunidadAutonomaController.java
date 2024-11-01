package com.funcionario.tai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.funcionario.tai.model.filter.ComunidadAutonomaFilter;
import com.funcionario.tai.service.ComunidadAutonomaService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/comunidadautonoma")
public class ComunidadAutonomaController {

	@Autowired
	private ComunidadAutonomaService comunidadAutonomaService;

	@GetMapping("")
	public String displayAll(Model model, Pageable pageable, HttpServletRequest request) {
		defaultModel(model, new ComunidadAutonomaFilter(), pageable, request);
		return "comunidadAutonoma/list";
	}

	@GetMapping("/buscar")
	public String search(Model model, Pageable pageable, HttpServletRequest request, ComunidadAutonomaFilter filter) {
		defaultModel(model, filter, pageable, request);
		return "comunidadAutonoma/list";
	}

	private void defaultModel(Model model, ComunidadAutonomaFilter filter, Pageable pageable,
			HttpServletRequest request) {
		model.addAttribute("page", comunidadAutonomaService.getPageSearch(filter, pageable));
		model.addAttribute("filter", filter);

	}
}
