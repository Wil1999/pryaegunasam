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

import com.flores.model.Menu;
import com.flores.repository.MenuRepository;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuRepository menuRepository;
	
	@GetMapping("/listar")
	private List<Menu> show(){
		return menuRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Menu> show(@PathVariable int id) {
		return menuRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Menu create(@RequestBody Menu menu) {
		return menuRepository.save(menu);
	}
	
	@PutMapping(path ="/{id}")
	private Menu update(@RequestBody Menu menu,@PathVariable int id) {
		Menu menuNow = menuRepository.findById(id).orElse(null);
		menuNow.setDescripcion(menu.getDescripcion());
		menuNow.setIcono(menu.getIcono());
		menuNow.setUrl(menu.getUrl());
		
		return menuRepository.save(menuNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		menuRepository.deleteById(id);
	}
}
