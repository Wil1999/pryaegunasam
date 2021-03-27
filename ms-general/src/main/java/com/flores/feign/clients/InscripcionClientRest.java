package com.flores.feign.clients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flores.feign.models.Inscripcion;

@FeignClient(name="msevento", url="localhost:8012")
@RequestMapping("/inscripcion")
public interface InscripcionClientRest {
	
	@GetMapping("/listByPersona/{id}")
	public Optional<List<Inscripcion>> listByPersona(@PathVariable int id);
}
