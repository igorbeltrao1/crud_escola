package br.com.igor.crud.escola.dto;

import br.com.igor.crud.escola.enumerate.Disciplinas;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProfessor(
		
		@NotBlank
		 String nome,
	
		 @NotBlank
		 String cpf,
		
		 @NotNull 
		 String telefone,
	
		 @NotBlank
		 Disciplinas disciplina,
		
		 @NotBlank
		 @Email 
		 String email,
		
		 @NotNull
		 boolean filhos,
		

		 @NotNull
		 int qtdeFilhos,
		
		 @NotNull
		 @Valid
		 DadosEndereco endereco
		
		) {

}
