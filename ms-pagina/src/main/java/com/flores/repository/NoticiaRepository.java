package com.flores.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flores.model.Autor;
import com.flores.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

	
}
