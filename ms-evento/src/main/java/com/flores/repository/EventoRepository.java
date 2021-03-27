package com.flores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

	
	List<Evento> findAllByTipoEventoId(int tipoEventoId);
}
