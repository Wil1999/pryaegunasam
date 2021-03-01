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

import com.flores.model.Roles;
import com.flores.model.dto.RolesDto;
import com.flores.repository.RolesRepository;

@RestController
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	private RolesRepository rolesRepository;
	
	@GetMapping("/listar")
	private List<Roles> show(){
		return rolesRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Roles> show(@PathVariable int id) {
		return rolesRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Roles create(@RequestBody RolesDto roles) {
		Roles rolesNow = new Roles();
		rolesNow.setDescripcion(roles.getDescripcion());
		return rolesRepository.save(rolesNow);
	}
	
	@PutMapping(path ="/{id}")
	private Roles update(@RequestBody RolesDto roles,@PathVariable int id) {
		Roles rolesNow = rolesRepository.findById(id).orElse(null);
		rolesNow.setDescripcion(roles.getDescripcion());
		
		return rolesRepository.save(rolesNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		rolesRepository.deleteById(id);
	}
}
