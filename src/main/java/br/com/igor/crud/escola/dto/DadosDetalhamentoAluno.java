package br.com.igor.crud.escola.dto;

import br.com.igor.crud.escola.model.Aluno;
import br.com.igor.crud.escola.model.Endereco;

public record DadosDetalhamentoAluno(
		
		Long id,

		String nome,

		String responsavel,

		String email,

		String telefone,

		String matricula,
		
		Endereco endereco
		) {
	
	public DadosDetalhamentoAluno(Aluno aluno) {
		
		this(aluno.getId(), aluno.getNome(), aluno.getResponsavel(),
				aluno.getEmail(), aluno.getTelefone(), aluno.getMatricula(),
				aluno.getEndereco());
		
	}

	
}
