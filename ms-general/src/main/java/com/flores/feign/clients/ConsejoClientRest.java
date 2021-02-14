package com.flores.feign.clients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flores.feign.models.Consejo;

@FeignClient(name="msasociado", url="localhost:8011")
@RequestMapping("/consejo")
public interface ConsejoClientRest {

	@GetMapping("/listPeriod/{id}")
	public Optional<List<Consejo>> listbyPeriodo(@PathVariable int id);
	
	@GetMapping("/listCar/{id}")
	public Optional<List<Consejo>> listbyCargo(@PathVariable int id);
}
