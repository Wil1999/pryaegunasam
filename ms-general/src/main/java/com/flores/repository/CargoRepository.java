package com.flores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
