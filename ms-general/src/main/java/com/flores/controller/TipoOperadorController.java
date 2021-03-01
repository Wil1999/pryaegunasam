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

import com.flores.model.TipoOperador;
import com.flores.model.dto.TipoOperadorDto;
import com.flores.repository.TipoOperadorRepository;

@RestController
@RequestMapping("/tipooperador")
public class TipoOperadorController {
	
	@Autowired
	private TipoOperadorRepository operadorRepository; 

	@GetMapping(path = "/listar")
	private List<TipoOperador> listar() {
		return operadorRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<TipoOperador> show(@PathVariable int id) {
		return operadorRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private TipoOperador create(@RequestBody TipoOperadorDto tipoOperador) {
		TipoOperador tipoOperadorNow = new TipoOperador();
		tipoOperadorNow.setOperador(tipoOperador.getOperador());
		return operadorRepository.save(tipoOperadorNow);
	}
	
	@PutMapping(path ="/{id}")
	private TipoOperador update(@RequestBody TipoOperador tipoOperador,@PathVariable int id) {
		TipoOperador tipoOperadorNow = operadorRepository.findById(id).orElse(null);
		tipoOperadorNow.setOperador(tipoOperador.getOperador());
		
		return operadorRepository.save(tipoOperadorNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		operadorRepository.deleteById(id);
	}
	
}
