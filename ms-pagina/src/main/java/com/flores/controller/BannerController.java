package com.flores.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flores.model.Banner;
import com.flores.repository.BannerRepository;

@RestController
@RequestMapping("/banner")
public class BannerController {
	
	@Autowired
	private BannerRepository bannerRepository;
	
	@GetMapping("/listar")
	private List<Banner> show(){
		return bannerRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Banner> show(@PathVariable int id) {
		return bannerRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Banner create(@RequestBody Banner banner) {
		return bannerRepository.save(banner);
	}
	
	@PutMapping(path ="/{id}")
	private Banner update(@RequestBody Banner banner,@PathVariable int id) {
		Banner bannerNow = bannerRepository.findById(id).orElse(null);
		bannerNow.setTitulo(banner.getTitulo());
		bannerNow.setDescripcion(banner.getDescripcion());
		bannerNow.setUrl(banner.getUrl());
		bannerNow.setCreatedAt(banner.getCreatedAt());
		bannerNow.setUpdatedAt(banner.getUpdatedAt());
		bannerNow.setEstado(banner.getEstado());
		bannerNow.setUsuarioId(banner.getUsuarioId());
		bannerNow.setRemove(banner.isRemove());
		return bannerRepository.save(bannerNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		bannerRepository.deleteById(id);
	}

}
