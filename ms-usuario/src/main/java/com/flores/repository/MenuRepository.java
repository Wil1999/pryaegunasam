package com.flores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
