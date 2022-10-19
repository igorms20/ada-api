package com.ada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ada.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
