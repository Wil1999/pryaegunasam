package com.flores.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flores.model.TipoCorreo;
import com.flores.model.dto.TipoCorreoDto;
import com.flores.repository.TipoCorreoRepository;

@RestController
@RequestMapping("/tipocorreo")
public class TipoCorreoController {
	
	@Autowired
	private TipoCorreoRepository correoRepository;
	
	@GetMapping(path = "/listar")
	private List<TipoCorreo> listar() {
		return correoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<TipoCorreo> show(@PathVariable int id) {
		return correoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private TipoCorreo create(@RequestBody TipoCorreoDto tipoCorreo) {
		TipoCorreo tipoCorreoNow = new TipoCorreo();
		tipoCorreoNow.setTipo(tipoCorreo.getTipo());
		return correoRepository.save(tipoCorreoNow);
	}
	
	@PutMapping(path ="/{id}")
	private TipoCorreo update(@RequestBody TipoCorreoDto tipoCorreo,@PathVariable int id) {
		TipoCorreo tipoCorreoNow = correoRepository.findById(id).orElse(null);
		tipoCorreoNow.setTipo(tipoCorreo.getTipo());
		
		return correoRepository.save(tipoCorreoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		correoRepository.deleteById(id);
	}
}
