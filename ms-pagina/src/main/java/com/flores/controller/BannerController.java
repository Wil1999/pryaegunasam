package com.flores.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flores.model.Banner;
import com.flores.model.dto.BannerResponse;
import com.flores.repository.BannerRepository;
import com.flores.util.ImageProcessing;

@RestController
@RequestMapping("/banner")
public class BannerController {
	
	@Autowired
	private BannerRepository bannerRepository;
	
	private ImageProcessing imageProcessing = new ImageProcessing();
	
	@GetMapping("/listar")
	private List<Banner> show(){
		return bannerRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Banner> show(@PathVariable int id) {
		return bannerRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private ResponseEntity<String> create(@RequestBody BannerResponse banner, @RequestParam("image") MultipartFile file) throws IOException {
		Instant dates = Instant.now();
		Banner bannerNow = new Banner();
		imageProcessing.saveFile(file);
		bannerNow.setTitulo(banner.getTitulo());
		bannerNow.setDescripcion(banner.getDescripcion());
		bannerNow.setUrl(imageProcessing.getRuta());
		bannerNow.setCreatedAt(Timestamp.from(dates));
		bannerNow.setUpdatedAt(Timestamp.from(dates));
		bannerNow.setEstado(banner.getEstado());
		bannerNow.setUsuarioId(banner.getUsuarioId());
		bannerNow.setRemove(banner.isRemove());
		bannerRepository.save(bannerNow);
		return new ResponseEntity<String>("BANNER CREADO CORRECTAMENTE",HttpStatus.CREATED);
	}
	
	@PutMapping(path ="/{id}")
	private ResponseEntity<String> update(@RequestBody BannerResponse banner,@PathVariable int id,@RequestParam("image") MultipartFile file) throws IOException  {
		Banner bannerNow = bannerRepository.findById(id).orElse(null);
		Instant dates = Instant.now();
		imageProcessing.saveFile(file);
		bannerNow.setTitulo(banner.getTitulo());
		bannerNow.setDescripcion(banner.getDescripcion());
		bannerNow.setUrl(imageProcessing.getRuta());
		bannerNow.setUpdatedAt(Timestamp.from(dates));
		bannerNow.setEstado(banner.getEstado());
		bannerNow.setUsuarioId(banner.getUsuarioId());
		bannerNow.setRemove(banner.isRemove());
		bannerRepository.save(bannerNow);
		return new ResponseEntity<String>("BANNER ACTUALIZADO CORRECTAMENTE",HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		bannerRepository.deleteById(id);
	}

}
