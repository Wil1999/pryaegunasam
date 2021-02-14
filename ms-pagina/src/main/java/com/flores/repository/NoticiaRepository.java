package com.flores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

}
