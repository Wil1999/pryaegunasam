package com.flores.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Persona;


public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	
	Optional<Persona> findByDni(String dni);
	
	
}
