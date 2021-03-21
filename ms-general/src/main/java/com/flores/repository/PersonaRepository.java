package com.flores.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flores.model.Persona;


public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	
	//@Query("select u from Usuario u where u.idPersona=?1")
	//@Query("select p from Persona where u.Dni=")
	
	Optional<Persona> findByDni(String dni);
	
}
