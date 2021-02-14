package com.flores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Documento;

public interface DocumentoRepository  extends JpaRepository<Documento, Integer>{

}
