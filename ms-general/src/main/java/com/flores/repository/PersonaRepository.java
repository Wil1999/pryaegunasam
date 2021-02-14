package com.flores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flores.feign.clients.UsuarioClienteRest;
import com.flores.feign.models.Usuario;
import com.flores.model.Persona;


public interface PersonaRepository extends JpaRepository<Persona, Integer> {	
}
