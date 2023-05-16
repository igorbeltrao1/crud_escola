package br.com.igor.crud.escola.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno(

		
		@Pattern(regexp = "\\d{4,6}")
		String matricula,
		
		@NotBlank
		String nome,

		@NotBlank
		String responsavel,

		@NotBlank
		@Email 
		String email,

		@NotNull
		String telefone,

		@NotNull
		@Valid
		DadosEndereco endereco

) {
}
