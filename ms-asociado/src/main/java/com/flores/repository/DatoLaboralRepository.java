package com.flores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.DatoLaboral;

public interface DatoLaboralRepository extends JpaRepository<DatoLaboral, Integer>{

	Optional<List<DatoLaboral>> findAllByTipoLaboralId(int tipoLaboralId);
	Optional<List<DatoLaboral>> findAllBySectorId(int sectorId);
	Optional<List<DatoLaboral>> findAllByInstitucionId(int institucionId);
	Optional<List<DatoLaboral>> findAllByPersonaId(int personaId);
}
