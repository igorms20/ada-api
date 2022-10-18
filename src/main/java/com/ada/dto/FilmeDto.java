package com.ada.dto;

import com.ada.model.Filme;

import lombok.Getter;

@Getter
public class FilmeDto {

	private String nome;
	private String descricao;

	private FilmeDto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Filme convertToObject() {
		return new Filme(nome, descricao);
	}

}
