package com.flores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Banner;

public interface BannerRepository extends JpaRepository<Banner, Integer> {

}
