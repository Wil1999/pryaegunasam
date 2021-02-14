package com.flores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Asociado;

public interface AsociadoRepository extends JpaRepository<Asociado,Integer> {

	Optional<List<Asociado>> findAllByPersonaId(int personaId);
}
