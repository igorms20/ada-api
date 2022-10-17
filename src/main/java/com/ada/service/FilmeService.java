package com.ada.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.exception.ExistingMovieException;
import com.ada.exception.MovieNotFoundException;
import com.ada.model.Filme;
import com.ada.repository.FilmeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmeService {

	private final FilmeRepository filmeRepository;

	@Transactional
	public List<Filme> getAll() {
		return filmeRepository.findAll();
	}

	@Transactional
	public Filme getById(Long id) {
		return filmeRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Filme não encontrado."));
	}

	@Transactional
	public Filme save(Filme filme) {
		if (getAll().contains(filme)) {
			throw new ExistingMovieException("O filme a ser inserido já existe");
		}

		return filmeRepository.save(filme);
	}

	@Transactional
	public Filme update(Long id, Filme filme) {
		Filme filmeExistente = getById(id);
		filmeExistente.setNome(filme.getNome());
		filmeExistente.setDescricao(filme.getDescricao());

		return filmeRepository.save(filmeExistente);
	}

}
