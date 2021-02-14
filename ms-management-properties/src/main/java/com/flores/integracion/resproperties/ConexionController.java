package com.flores.integracion.resproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flores.dtoconfiguracion.ConfiguracionParametros;
import com.flores.integracion.parametros.Conexion;

@RestController
public class ConexionController {

	@Autowired
	private ConfiguracionParametros service;
	
	@GetMapping(path = "datosconexion")
	public Conexion getDatosConexionHidro() {
		Conexion datosconexion = new Conexion(
				service.getDriverclassname(),
				service.getUrl(),
				service.getUsername(),
				service.getPassword()
				);
		
		return datosconexion;
	}
}
