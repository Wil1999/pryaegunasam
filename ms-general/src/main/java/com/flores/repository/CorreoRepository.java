package com.flores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Correo;

public interface CorreoRepository extends JpaRepository<Correo, Integer> {

}
