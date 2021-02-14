package com.flores.feign.clients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flores.feign.models.Asociado;

@FeignClient(name="msasociado", url="localhost:8011")
@RequestMapping("/asociado")
public interface AsociadoClientRest {
	
	@GetMapping("/listPer/{id}")
	public Optional<List<Asociado>> listbyPersona(@PathVariable int id);
}
