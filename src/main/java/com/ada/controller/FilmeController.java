package com.ada.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.dto.FilmeDto;
import com.ada.model.Filme;
import com.ada.service.FilmeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<Filme>> getAllMovies() {

        return new ResponseEntity<>(filmeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getMovieById(@PathVariable Long id) {

        return new ResponseEntity<>(filmeService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Filme> saveMovie(@Valid @RequestBody FilmeDto filmeDto) {

        return new ResponseEntity<>(filmeService.save(filmeDto.convertToObject()), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> updateMovie(@PathVariable Long id, @Valid @RequestBody FilmeDto filmeDto) {

        return new ResponseEntity<>(filmeService.update(id, filmeDto.convertToObject()), HttpStatus.ACCEPTED);
    }

}
