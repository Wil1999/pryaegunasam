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

import com.flores.model.UsuRolMenu;
import com.flores.repository.UsuRolMenuRepository;

@RestController
@RequestMapping("/usurolmenu")
public class UsuRolMenuController {

	@Autowired
	private UsuRolMenuRepository rolMenuRepository;
	
	@GetMapping("/listar")
	private List<UsuRolMenu> show(){
		return rolMenuRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<UsuRolMenu> show(@PathVariable int id) {
		return rolMenuRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private UsuRolMenu create(@RequestBody UsuRolMenu usuRolMenu) {
		return rolMenuRepository.save(usuRolMenu);
	}
	
	@PutMapping(path ="/{id}")
	private UsuRolMenu update(@RequestBody UsuRolMenu usuRolMenu,@PathVariable int id) {
		UsuRolMenu usuRolMenuNow = rolMenuRepository.findById(id).orElse(null);
		usuRolMenuNow.setUsuarioRoles(usuRolMenu.getUsuarioRoles());
		usuRolMenuNow.setMenu(usuRolMenu.getMenu());
		usuRolMenuNow.setEstado(usuRolMenu.isEstado());
		
		return rolMenuRepository.save(usuRolMenuNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		rolMenuRepository.deleteById(id);
	}
}
