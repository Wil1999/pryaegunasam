package com.flores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.CronogramaEvento;

public interface CronogramaEventoRepository extends JpaRepository<CronogramaEvento, Integer> {

}
