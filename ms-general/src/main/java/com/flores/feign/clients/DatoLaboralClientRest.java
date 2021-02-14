package com.flores.feign.clients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flores.feign.models.DatoLaboral;


@FeignClient(name = "msasociado", url="localhost:8011")
@RequestMapping("/datolaboral")
public interface DatoLaboralClientRest {

	@GetMapping("/listTL/{id}")
	public Optional<List<DatoLaboral>> listTL(@PathVariable int id);
	
	@GetMapping("/listSec/{id}")
	public Optional<List<DatoLaboral>> listSec(@PathVariable int id);
	
	@GetMapping("/listInst/{id}")
	public Optional<List<DatoLaboral>> listInst(@PathVariable int id);
	
	@GetMapping("/listPer/{id}")
	public Optional<List<DatoLaboral>> listPer(@PathVariable int id);
}
