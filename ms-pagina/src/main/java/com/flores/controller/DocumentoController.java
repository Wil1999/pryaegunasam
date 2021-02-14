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

import com.flores.model.Documento;
import com.flores.repository.DocumentoRepository;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

	@Autowired
	private DocumentoRepository documentoRepository;
	
	@GetMapping("/listar")
	private List<Documento> show(){
		return documentoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Documento> show(@PathVariable int id) {
		return documentoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Documento create(@RequestBody Documento documento) {
		return documentoRepository.save(documento);
	}
	
	@PutMapping(path ="/{id}")
	private Documento update(@RequestBody Documento documento,@PathVariable int id) {
		Documento documentoNow = documentoRepository.findById(id).orElse(null);
		documentoNow.setDescripcion(documento.getDescripcion());
		documentoNow.setUrl(documento.getUrl());
		documentoNow.setUsuarioId(documento.getUsuarioId());
		
		return documentoRepository.save(documentoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		documentoRepository.deleteById(id);
	}
}
