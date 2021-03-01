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

import com.flores.feign.clients.DatoAcademicoClientRest;
import com.flores.feign.models.DatoAcademico;
import com.flores.model.GradoAcademico;
import com.flores.model.dto.GradoAcademicoDto;
import com.flores.repository.GradoAcademicoRepository;

@RestController
@RequestMapping("/gradoacademico")
public class GradoAcademicoController {

	@Autowired
	private GradoAcademicoRepository academicoRepository;
	
	@Autowired
	private DatoAcademicoClientRest datoClientRepository;
	
	@GetMapping(path = "/listar")
	private List<GradoAcademico> listar() {
		List<GradoAcademico> grados = academicoRepository.findAll();
		for (GradoAcademico g : grados) {
			List<DatoAcademico> datos = datoClientRepository.listbyGrado(g.getId()).orElse(null);
			g.setDatoAcademico(datos);
		}
		return grados;
	}
	
	@GetMapping(path = "/{id}")
	private Optional<GradoAcademico> show(@PathVariable int id) {
		return academicoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private GradoAcademico create(@RequestBody GradoAcademicoDto gradoAcademico) {
		GradoAcademico gradoAcademicoNow = new GradoAcademico();
		gradoAcademicoNow.setDescripcion(gradoAcademico.getDescripcion());
		return academicoRepository.save(gradoAcademicoNow);
	}
	
	@PutMapping(path ="/{id}")
	private GradoAcademico update(@RequestBody GradoAcademicoDto gradoAcademico,@PathVariable int id) {
		GradoAcademico gradoAcademicoNow = academicoRepository.findById(id).orElse(null);
		gradoAcademicoNow.setDescripcion(gradoAcademico.getDescripcion());
		
		return academicoRepository.save(gradoAcademicoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		academicoRepository.deleteById(id);
	}
}
