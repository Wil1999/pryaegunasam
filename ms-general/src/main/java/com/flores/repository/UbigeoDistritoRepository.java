package com.flores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.UbigeoDistrito;

public interface UbigeoDistritoRepository extends JpaRepository<UbigeoDistrito, Integer> {

	List<UbigeoDistrito> findAllByUbigeoProvinciaId(int ubigeoProvinciaId);
}
