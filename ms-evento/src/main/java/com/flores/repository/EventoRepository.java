package com.flores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
