package com.flores.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flores.model.Usuario;
import com.flores.model.dto.UsuarioDto;
import com.flores.model.dto.UsuarioResponse;
import com.flores.repository.UsuarioRepository;
import com.flores.util.RandomPass;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EntityManager em;
	
	@GetMapping(path="/listarUsuariosTabla")
	private List<UsuarioResponse> listaUsuarios() {
		List<Usuario> listaUsuario = usuarioRepository.findAll();
		List<UsuarioResponse> listaUsuarioResult= new ArrayList<UsuarioResponse>();
		for(Usuario u: listaUsuario) {
			Query nombre = em.createNativeQuery("select u.id,concat(p.nombre,' ',p.apellido_paterno,' ',p.apellido_materno), u.user_name, u.estado from gestion_usuario.usuario u\r\n"
					+ "inner join general.persona p on p.id = u.id_persona and u.id = ?");
			nombre.setParameter(1,u.getId());
			List<Object[]> result = nombre.getResultList();
			for(Object[] r : result) {
				UsuarioResponse data = new UsuarioResponse(((Integer) r[0]).intValue(),(String) r[1], (String) r[2], String.valueOf(r[3]));
				listaUsuarioResult.add(data);
			}
		}
		return listaUsuarioResult;
	}
	
	//Resetear la contraseña FIXME Revisar
	@PutMapping(path= "/resetearContrasena/{id}")
	private ResponseEntity<String> resetearContraseña(@PathVariable int id){
		RandomPass randomPass = new RandomPass();
		String contraseña = randomPass.getPassword();
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		//if(this.passwordEncoder.matches(contraseña, usuario.getPass())) {
		//	usuarioRepository.save(usuario);
		//	return new ResponseEntity<String>("NO SE PUEDE ALMACENAR LA MISMA CONTRASEÑA", HttpStatus.CONFLICT);
		//}
		String pass = BCrypt.hashpw(contraseña,BCrypt.gensalt());
		System.out.print(pass);
		usuario.setPass(pass);
		usuarioRepository.save(usuario);
		return new ResponseEntity<>("CONTRASEÑA MODIFICADA CORRECTAMENTE", HttpStatus.OK);
	}
	
	//Habilitar o deshabilitar un usuario
	@PutMapping(path ="/darBajaAlta/{id}")
	private ResponseEntity<String> darBajaAltaUsuario(@PathVariable int id, @RequestParam boolean bajaAlta){
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		usuario.setEstado(bajaAlta);
		//
		if(bajaAlta) {
			usuarioRepository.save(usuario);
			return new ResponseEntity<String>("USUARIO DADO DE ALTA EXITOSAMENTE",HttpStatus.ALREADY_REPORTED);
		}
		usuarioRepository.save(usuario);
		return new ResponseEntity<String>("USUARIO DADO DE BAJA EXITOSAMENTE",HttpStatus.ALREADY_REPORTED);
	}
	
	@GetMapping("/listar")
	private List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Usuario> show(@PathVariable int id) {
		return usuarioRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Usuario create(@RequestBody UsuarioDto usuario) {
		//String pass = randomPass.getPassword();
		Usuario usuarioNow = new Usuario();
		usuarioNow.setUserName(usuario.getUserName());
		usuarioNow.setIdPersona(usuario.getIdPersona());
		usuarioNow.setPass(BCrypt.hashpw(usuario.getPass(),BCrypt.gensalt()));
		usuarioNow.setEstado(usuario.isEstado());
		usuarioNow.setRemove(usuario.isRemove());
		return usuarioRepository.save(usuarioNow);
	}
	
	@PutMapping(path ="/{id}")
	private Usuario update(@RequestBody UsuarioDto usuario,@PathVariable int id) {
		Usuario usuarioNow = usuarioRepository.findById(id).orElse(null);
		usuarioNow.setUserName(usuario.getUserName());
		usuarioNow.setIdPersona(usuario.getIdPersona());
		usuarioNow.setEstado(usuario.isEstado());
		usuarioNow.setRemove(usuario.isRemove());
		
		return usuarioRepository.save(usuarioNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		usuarioRepository.deleteById(id);
	}
	
	@GetMapping(path = "/obtener/{idPersona}")
	public Optional<List<Usuario>> buscarPorId(@PathVariable("idPersona") int idPersona) {
		return usuarioRepository.buscarPorId(idPersona);
	}
}
