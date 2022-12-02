package com.ada.dto;

import javax.validation.constraints.NotBlank;

import com.ada.model.Filme;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class FilmeDto {

    @NotBlank(message = "Esse item não pode ser nulo ou vazio")
    private String nome;
    @NotBlank(message = "Esse item não pode ser nulo ou vazio")
    private String descricao;

    public Filme convertToObject() {
        return Filme.builder()
                .nome(nome)
                .descricao(descricao)
                .build();
    }

}
