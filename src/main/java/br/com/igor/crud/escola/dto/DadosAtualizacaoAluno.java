package br.com.igor.crud.escola.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(
		@NotNull
		Long id,
		String nome,
		String responsavel,
		String email,
		DadosEndereco endereco) {

}
	