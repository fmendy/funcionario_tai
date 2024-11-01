package com.funcionario.tai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.funcionario.tai.entity.ComunidadAutonoma;
import com.funcionario.tai.entity.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

	List<Provincia> findByActivoTrue();

	List<Provincia> findByActivoTrueOrderByNombre();

	Provincia findByActivoTrueAndId(Long id);

	Provincia findByActivoTrueAndNombreContainsIgnoreCase(String nombre);

	Provincia findByActivoTrueAndCodigoINE(String codigoIne);

	List<Provincia> findByActivoTrueAndComunidadAutonoma(ComunidadAutonoma comunidadAutonoma);

	List<Provincia> findByActivoTrueAndComunidadAutonomaIdOrderByNombre(Long comunidadAutonoma);

}
