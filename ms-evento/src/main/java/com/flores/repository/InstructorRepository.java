package com.flores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	Optional<List<Instructor>> findAllByIdPersona(int idPersona);
}
