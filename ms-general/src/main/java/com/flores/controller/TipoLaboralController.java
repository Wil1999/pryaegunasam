package com.flores.controller;

import java.util.ArrayList;
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

import com.flores.feign.clients.DatoLaboralClientRest;
import com.flores.feign.models.DatoLaboral;
import com.flores.model.TipoLaboral;
import com.flores.model.dto.TipoLaboralDto;
import com.flores.repository.TipoLaboralRepository;

@RestController
@RequestMapping("/tipolaboral")
public class TipoLaboralController {

	@Autowired
	private TipoLaboralRepository laboralRepository;
	
	@Autowired
	private DatoLaboralClientRest datoLaboralClient;
	
	
	@GetMapping(path="/listDatoLab")
	private List<TipoLaboral> listaDatoLab(){
		List<TipoLaboral> laboral = laboralRepository.findAll();
		for (TipoLaboral d : laboral) {
			List<DatoLaboral> datolab = new ArrayList<DatoLaboral>();
			datolab = datoLaboralClient.listTL(d.getId()).orElse(null);
			d.setDatoLaboral(datolab);
		}
		return laboral;
	}
	
	@GetMapping(path = "/listar")
	private List<TipoLaboral> listar() {
		return laboralRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<TipoLaboral> show(@PathVariable int id) {
		return laboralRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private TipoLaboral create(@RequestBody TipoLaboralDto tipoLaboral) {
		TipoLaboral tipoLaboralNow = new TipoLaboral();
		tipoLaboralNow.setDescripcion(tipoLaboral.getDescripcion());
		return laboralRepository.save(tipoLaboralNow);
	}
	
	@PutMapping(path ="/{id}")
	private TipoLaboral update(@RequestBody TipoLaboralDto tipoLaboral,@PathVariable int id) {
		TipoLaboral tipoLaboralNow = laboralRepository.findById(id).orElse(null);
		tipoLaboralNow.setDescripcion(tipoLaboral.getDescripcion());
		
		return laboralRepository.save(tipoLaboralNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		laboralRepository.deleteById(id);
	}
}
