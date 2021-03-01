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

import com.flores.feign.clients.ConsejoClientRest;
import com.flores.feign.models.Consejo;
import com.flores.model.Periodo;
import com.flores.model.dto.PeriodoDto;
import com.flores.repository.PeriodoRepository;

@RestController
@RequestMapping("/periodo")
public class PeriodoController {

	@Autowired
	private PeriodoRepository periodoRepository;
	
	@Autowired
	private ConsejoClientRest consejoClientRest;
	
	@GetMapping(path = "/listar")
	private List<Periodo> listar() {
		List<Periodo> periodos = periodoRepository.findAll();
		for(Periodo p : periodos){
			List<Consejo> consejo = consejoClientRest.listbyPeriodo(p.getId()).orElse(null);
			p.setConsejo(consejo);
		}
		return periodos;
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Periodo> show(@PathVariable int id) {
		return periodoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Periodo create(@RequestBody PeriodoDto periodo) {
		Periodo periodoNow = new Periodo();
		periodoNow.setAnio(periodo.getAnio());
		return periodoRepository.save(periodoNow);
	}
	
	@PutMapping(path ="/{id}")
	private Periodo update(@RequestBody PeriodoDto periodo,@PathVariable int id) {
		Periodo periodoNow = periodoRepository.findById(id).orElse(null);
		periodoNow.setAnio(periodo.getAnio());
		
		return periodoRepository.save(periodoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		periodoRepository.deleteById(id);
	}
}
