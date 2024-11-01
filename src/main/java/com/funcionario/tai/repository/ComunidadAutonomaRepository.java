package com.funcionario.tai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.funcionario.tai.entity.ComunidadAutonoma;

@Repository
public interface ComunidadAutonomaRepository extends JpaRepository<ComunidadAutonoma, Long> {

	List<ComunidadAutonoma> findByActivoTrue();
	
	List<ComunidadAutonoma> findByActivoTrueOrderByNombre();

	ComunidadAutonoma findByActivoTrueAndId(Long id);

}
