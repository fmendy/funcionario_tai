package com.funcionario.tai.utility;

import java.util.ArrayList;
import java.util.List;

import com.funcionario.tai.entity.ComunidadAutonoma;
import com.funcionario.tai.model.ComunidadAutonomaForm;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ComunidadAutonomaUtil {

	public ComunidadAutonomaForm comunidadAutonomaToForm(ComunidadAutonoma comunidadAutonoma) {
		ComunidadAutonomaForm retVal = new ComunidadAutonomaForm();
		retVal.setId(comunidadAutonoma.getId());
		retVal.setNombre(comunidadAutonoma.getNombre());
		return retVal;
	}

	public List<ComunidadAutonomaForm> listComunidadAutonomaToListForm(List<ComunidadAutonoma> list) {
		List<ComunidadAutonomaForm> retVal = new ArrayList<>();
		for (ComunidadAutonoma ca : list) {
			retVal.add(comunidadAutonomaToForm(ca));
		}
		return retVal;
	}
}