package com.flores.feign.clients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flores.feign.models.Instructor;

@FeignClient(name="msevento", url="localhost:8012")
@RequestMapping("/instructor")
public interface InstructorClientRest {

	@GetMapping("/listByPers/{id}")
	public Optional<List<Instructor>> listByPersona(@PathVariable int id);
	
}
