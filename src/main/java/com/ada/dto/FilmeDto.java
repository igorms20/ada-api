package com.ada.dto;

import com.ada.model.Filme;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FilmeDto {

	private String nome;
	private String descricao;

	public Filme convertToObject() {
		return Filme.builder()
				.nome(nome)
				.descricao(descricao)
				.build();
	}

}
