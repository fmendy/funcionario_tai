function getListProvinciasByComunidadAjax() {
	var idComunidad = $("#idComunidadAutonoma").find(":selected").val();
	$('#idProvincia')
		.find('option')
		.remove()
		.end();

	$('#idMunicipio')
		.find('option')
		.remove()
		.end();

	$('#idProvincia').append('<option value=""></option>');

	if (idComunidad != null && idComunidad != "") {

		$.ajax({
			type: "GET",
			url: "/ajax/comunidad/" + idComunidad + "/provincia",
			dataType: "json",
			success: function(datos) {
				datos.forEach(function(datos) {
					$('#idProvincia').append('<option value="' + datos.id + '">' + datos.nombre + '</option>');
				});
			}
		});
	}
	else {
		$.ajax({
			type: "GET",
			url: "/ajax/comunidad/todas/provincia",
			dataType: "json",
			success: function(datos) {
				datos.forEach(function(datos) {
					$('#idProvincia').append('<option value="' + datos.id + '">' + datos.nombre + '</option>');
				});
			}
		});

	}
}

function getListMunicipioByProvinciaAjax() {
	var idProvincia = $("#idProvincia").find(":selected").val();
	$('#idMunicipio')
		.find('option')
		.remove()
		.end();

	$('#idMunicipio').append('<option value=""></option>');



	if (idProvincia != null && idProvincia != "") {
		$.ajax({
			type: "GET",
			url: "/ajax/comunidad/provincia/" + idProvincia + "/municipio",
			dataType: "json",
			success: function(datos) {
				datos.forEach(function(datos) {
					//alert(datos.id);
					$('#idMunicipio').append('<option value="' + datos.id + '">' + datos.nombre + '</option>');
				});
			}
		});
	}
}


