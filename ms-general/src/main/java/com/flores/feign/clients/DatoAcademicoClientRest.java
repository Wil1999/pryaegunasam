package com.flores.feign.clients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flores.feign.models.DatoAcademico;



@FeignClient(name = "msasociado", url = "localhost:8011")
@RequestMapping(path="/datoacademico")
public interface DatoAcademicoClientRest {
	
	@GetMapping("/listGrad/{id}")
	public Optional<List<DatoAcademico>> listbyGrado(@PathVariable int id);
	
	@GetMapping("/listEsp/{id}")
	public Optional<List<DatoAcademico>> listbyEspecialidad(@PathVariable int id);
	
	@GetMapping("/listPer/{id}")
	public Optional<List<DatoAcademico>> listbyPersona(@PathVariable int id);
}
