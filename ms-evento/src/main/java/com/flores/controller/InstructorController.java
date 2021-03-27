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

import com.flores.model.Instructor;
import com.flores.model.dto.InstructorDto;
import com.flores.repository.InstructorRepository;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	@GetMapping("/listByPers/{id}")
	private Optional<List<Instructor>> listByPersona(@PathVariable int id){
		return instructorRepository.findAllByIdPersona(id);
	}
	
	@GetMapping("/listar")
	private List<Instructor> show(){
		return instructorRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Instructor> show(@PathVariable int id) {
		return instructorRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Instructor create(@RequestBody InstructorDto instructor) {
		Instructor instructorNow = new Instructor();
		instructorNow.setIdPersona(instructor.getIdPersona());
		return instructorRepository.save(instructorNow);
	}
	
	@PutMapping(path ="/{id}")
	private Instructor update(@RequestBody Instructor instructor,@PathVariable int id) {
		Instructor instructorNow = instructorRepository.findById(id).orElse(null);
		instructorNow.setIdPersona(instructor.getIdPersona());
		return instructorRepository.save(instructorNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		instructorRepository.deleteById(id);
	}

}
