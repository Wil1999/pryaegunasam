package com.flores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Imagen;

public interface ImagenRepository extends JpaRepository<Imagen, Integer>{

	Optional<List<Imagen>> findAllByEventoId(int eventoId);
}
