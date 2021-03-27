package com.flores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.UbigeoProvincia;

public interface UbigeoProvinciaRepository extends JpaRepository<UbigeoProvincia, Integer> {
	
	List<UbigeoProvincia> findAllByUbigeoDepartamentoId (int ubigeoDepartamentoId); 

}
