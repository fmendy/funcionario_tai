package com.funcionario.tai.model.specifications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.funcionario.tai.entity.ComunidadAutonoma;
import com.funcionario.tai.model.filter.ComunidadAutonomaFilter;

import jakarta.persistence.criteria.Predicate;

public class ComunidadAutonomaSpecifications {

	public static Specification<ComunidadAutonoma> filter(ComunidadAutonomaFilter filter) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			predicates.add(criteriaBuilder.equal(root.get("activo"), true));

			if (StringUtils.hasText(filter.getNombre())) {
				Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("nombre")),
						"%" + filter.getNombre().toUpperCase() + "%");
				filter.getNombre();
				predicates.add(predicate);
			}

			return criteriaBuilder.and(predicates.toArray((new Predicate[0])));
		};
	}
}
