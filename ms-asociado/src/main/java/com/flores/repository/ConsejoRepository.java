package com.flores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Consejo;

public interface ConsejoRepository extends JpaRepository<Consejo, Integer> {

	Optional<List<Consejo>> findAllByIdPeriodo(int idPeriodo);
	Optional<List<Consejo>> findAllByCargoId(int cargoId);
}
