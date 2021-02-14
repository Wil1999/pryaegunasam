package com.flores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Inscripcion;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer>{

	Optional<List<Inscripcion>> findAllByPersonaId(int personaId);
}
