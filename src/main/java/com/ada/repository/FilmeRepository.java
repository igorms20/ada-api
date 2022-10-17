package com.ada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ada.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
