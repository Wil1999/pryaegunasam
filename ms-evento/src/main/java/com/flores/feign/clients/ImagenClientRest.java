package com.flores.feign.clients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flores.feign.models.Imagen;

@FeignClient(name="mspagina", url="localhost:8013")
@RequestMapping("/imagen")
public interface ImagenClientRest {

	@GetMapping("/listByEvento/{id}")
	public Optional<List<Imagen>> listByEvento(@PathVariable int id);
	
}
