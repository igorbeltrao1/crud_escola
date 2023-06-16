package br.com.igor.crud.escola.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProfessor(
		@NotNull
		Long id,
		String nome,
		String email,
		DadosEndereco endereco) {

}
