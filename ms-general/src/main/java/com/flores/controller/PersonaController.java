package com.flores.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flores.feign.clients.AsociadoClientRest;
import com.flores.feign.clients.DatoAcademicoClientRest;
import com.flores.feign.clients.DatoLaboralClientRest;
import com.flores.feign.clients.InscripcionClientRest;
import com.flores.feign.clients.InstructorClientRest;
import com.flores.feign.clients.UsuarioClienteRest;
import com.flores.feign.models.Asociado;
import com.flores.feign.models.DatoAcademico;
import com.flores.feign.models.DatoLaboral;
import com.flores.feign.models.Inscripcion;
import com.flores.feign.models.Instructor;
import com.flores.feign.models.Usuario;
import com.flores.model.Persona;
import com.flores.model.dto.PersonaDto;
import com.flores.repository.PersonaRepository;

@RestController
@RequestMapping(path = "/persona")
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private UsuarioClienteRest usuclienteRest; 
	
	@Autowired
	private DatoLaboralClientRest  laboclienteRest;
	
	@Autowired
	private DatoAcademicoClientRest academicoClientRest;
	
	@Autowired
	private AsociadoClientRest asociadoClientRest;
	
	@Autowired
	private InscripcionClientRest inscripcionClientRest;
	
	@Autowired
	private InstructorClientRest instructorClientRest; 
	
	
	//Obtener datos de persona por DNI 
	@GetMapping(path="/{dni}")
	private Persona obtenerPersonaPorDni(@PathVariable String dni){
		Persona p = personaRepository.findByDni(dni).orElse(null);
		
		List<Usuario> dato = new ArrayList<Usuario>();
		dato = usuclienteRest.buscarPorId(p.getId()).orElse(null);
		p.setUsuario(dato);
		
		List<Instructor> dato1 = instructorClientRest.listByPersona(p.getId()).orElse(null);
		p.setInstructor(dato1);
		
		List<Inscripcion> dato2 = inscripcionClientRest.listByPersona(p.getId()).orElse(null);
		p.setInscripcion(dato2);
		
		List<Asociado> dato3 = asociadoClientRest.listbyPersona(p.getId()).orElse(null);
		p.setAsociado(dato3);
		
		List<DatoAcademico> dato4 = new ArrayList<DatoAcademico>();
		dato4 = academicoClientRest.listbyPersona(p.getId()).orElse(null);
		p.setDatoAcademico(dato4);
		
		List<DatoLaboral> dato5 = new ArrayList<DatoLaboral>();
		dato5 = laboclienteRest.listPer(p.getId()).orElse(null);
		p.setDatoLaboral(dato5);
		
		return p;
	}
	
	//Validacion de existencia de persona unica
	@PostMapping(path="/personaUnica")
	private ResponseEntity<String> validacionPersonaUnica(@RequestBody PersonaDto personaDto){
		List<Persona> personas = personaRepository.findAll();
		for(Persona p : personas) {
			if(personaDto.getDni().equals(p.getDni())) {
				return new ResponseEntity<String>("VALIDACION PERSONA INCORRECTA",HttpStatus.CONFLICT);
			}
		}
		return new ResponseEntity<String>("VALIDACION PERSONA CORRECTA",HttpStatus.ACCEPTED);
	}
	
	//@GetMapping(path = "/listUsuarios")
	//private List<Persona> listUsuarios() {
//	//	List<Usuario> usuPer = new ArrayList<Usuario>();
	//	List<Persona> personas = personaRepository.findAll();
//	//	List<Usuario> usuarios = clienteRest.listar();
	//	for (Persona p : personas) {
//
	//		List<Usuario> dato = new ArrayList<Usuario>();
		//	dato = usuclienteRest.buscarPorId(p.getId()).orElse(null);
			//p.setUsuario(dato);
			
	//	}
	//	return personas;
	//}	
	
	//@GetMapping(path= "/listDatoLab")
	//private List<Persona> listDatoLab(){
	//	List<Persona> persona = personaRepository.findAll();
	//	for (Persona p: persona) {
	//		List<DatoLaboral> dato = new ArrayList<DatoLaboral>();
	//		dato = laboclienteRest.listPer(p.getId()).orElse(null);
	//		p.setDatoLaboral(dato);
	//	}
	//	return persona;
	//}
	
	//@GetMapping("/listDatoAcad")
	//private List<Persona> listDatoAcademico(){
	//	List<Persona> persona = personaRepository.findAll();
	//	for (Persona p: persona) {
	//		List<DatoAcademico> dato = new ArrayList<DatoAcademico>();
	//		dato = academicoClientRest.listbyPersona(p.getId()).orElse(null);
	//		p.setDatoAcademico(dato);
	//	}
	//	return persona;
	//}
	
	//@GetMapping("/listAsoc")
	//private List<Persona> listAsociado(){
	//	List<Persona> persona = personaRepository.findAll();
	//	for (Persona p: persona) {
	//		List<Asociado> dato = asociadoClientRest.listbyPersona(p.getId()).orElse(null);
	//		p.setAsociado(dato);
	//	}
	//	return persona;
	//}
	
	//@GetMapping("/listInsc")
	//private List<Persona> listInscripcion(){
	//	List<Persona> persona = personaRepository.findAll();
	//	for (Persona p: persona) {
	//		List<Inscripcion> dato = inscripcionClientRest.listByPersona(p.getId()).orElse(null);
	//		p.setInscripcion(dato);
	//	}
	//	return persona;
	//}
	
	//@GetMapping("/listInstrutor")
	//private List<Persona> listInstructor(){
	//	List<Persona> persona = personaRepository.findAll();
	//	for (Persona p: persona) {
	//		List<Instructor> dato = instructorClientRest.listByPersona(p.getId()).orElse(null);
	//		p.setInstructor(dato);
	//	}
	//	return persona;
	//}
	@GetMapping(path="/listar")
	public List<Persona> listar(){
		return personaRepository.findAll();
	}
	
	@GetMapping(path = "/listarAll")
	public List<Persona> listarAll() {
		List<Persona> persona = personaRepository.findAll();
		for (Persona p : persona){
			List<Usuario> dato = new ArrayList<Usuario>();
			dato = usuclienteRest.buscarPorId(p.getId()).orElse(null);
			p.setUsuario(dato);
			
			List<Instructor> dato1 = instructorClientRest.listByPersona(p.getId()).orElse(null);
			p.setInstructor(dato1);
			
			List<Inscripcion> dato2 = inscripcionClientRest.listByPersona(p.getId()).orElse(null);
			p.setInscripcion(dato2);
			
			List<Asociado> dato3 = asociadoClientRest.listbyPersona(p.getId()).orElse(null);
			p.setAsociado(dato3);
			
			List<DatoAcademico> dato4 = new ArrayList<DatoAcademico>();
			dato4 = academicoClientRest.listbyPersona(p.getId()).orElse(null);
			p.setDatoAcademico(dato4);
			
			List<DatoLaboral> dato5 = new ArrayList<DatoLaboral>();
			dato5 = laboclienteRest.listPer(p.getId()).orElse(null);
			p.setDatoLaboral(dato5);
		}
		return persona;
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Persona> show(@PathVariable int id) {
		return personaRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Persona create(@RequestBody PersonaDto persona) {
		Persona personaNow = new Persona();
		personaNow.setDni(persona.getDni());
		personaNow.setApellidoPaterno(persona.getApellidoPaterno());
		personaNow.setApellidoMaterno(persona.getApellidoMaterno());
		personaNow.setNombre(persona.getNombre());
		personaNow.setUbigeoDistritoNacId(persona.getUbigeoDistritoNacId());
		personaNow.setUbigeoDistritoDomId(persona.getUbigeoDistritoDomId());
		personaNow.setDireccion(persona.getDireccion());
		personaNow.setFechaNacimiento(persona.getFechaNacimiento());
		return personaRepository.save(personaNow);
	}
	
	@PutMapping(path ="/{id}")
	private Persona update(@RequestBody PersonaDto persona,@PathVariable int id) {
		Persona personaNow = personaRepository.findById(id).orElse(null);
		personaNow.setDni(persona.getDni());
		personaNow.setApellidoPaterno(persona.getApellidoPaterno());
		personaNow.setApellidoMaterno(persona.getApellidoMaterno());
		personaNow.setNombre(persona.getNombre());
		personaNow.setUbigeoDistritoNacId(persona.getUbigeoDistritoNacId());
		personaNow.setUbigeoDistritoDomId(persona.getUbigeoDistritoDomId());
		personaNow.setDireccion(persona.getDireccion());
		personaNow.setFechaNacimiento(persona.getFechaNacimiento());
		
		return personaRepository.save(personaNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		personaRepository.deleteById(id);
	}
	
	
}
