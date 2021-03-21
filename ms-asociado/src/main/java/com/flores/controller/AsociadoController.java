package com.flores.controller;

import java.util.Date;
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

import com.flores.model.Asociado;
import com.flores.model.dto.AsociadoDto;
import com.flores.repository.AsociadoRepository;

@RestController
@RequestMapping("/asociado")
public class AsociadoController {

	@Autowired
	private AsociadoRepository asociadoRepository;
	
	@GetMapping("/listPer/{id}")
	private Optional<List<Asociado>> listbyPersona(@PathVariable int id){
		return asociadoRepository.findAllByPersonaId(id);
	}
	
	@GetMapping("/listar")
	private List<Asociado> show(){
		return asociadoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Asociado> show(@PathVariable int id) {
		return asociadoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Asociado create(@RequestBody AsociadoDto asociado) {
		Asociado asociadoNow = new Asociado();
		asociadoNow.setNumero(asociado.getNumero());
		asociadoNow.setPersonaId(asociado.getPersonaId());
		asociadoNow.setFechaIncorporacion(new Date());
		asociadoNow.setEstado(asociado.isEstado());
		asociadoNow.setRemove(asociado.isRemove());
		asociadoNow.setUsuarioId(asociado.getUsuarioId());
		return asociadoRepository.save(asociadoNow);
	}
	
	@PutMapping(path ="/{id}")
	private Asociado update(@RequestBody AsociadoDto asociado,@PathVariable int id) {
		Asociado asociadoNow = asociadoRepository.findById(id).orElse(null);
		asociadoNow.setNumero(asociado.getNumero());
		asociadoNow.setPersonaId(asociado.getPersonaId());
		asociadoNow.setEstado(asociado.isEstado());
		asociadoNow.setRemove(asociado.isRemove());
		asociadoNow.setUsuarioId(asociado.getUsuarioId());
		return asociadoRepository.save(asociadoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		asociadoRepository.deleteById(id);
	}
}
