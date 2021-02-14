package com.flores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.DatoAcademico;

public interface DatoAcademicoRepository extends JpaRepository<DatoAcademico, Integer> {

	Optional<List<DatoAcademico>> findAllByGradoAcadId(int gradoAcadId);
	Optional<List<DatoAcademico>> findAllByEspecialidadId(int especialidadId);
	Optional<List<DatoAcademico>> findAllByPersonaId(int personaId);
}
