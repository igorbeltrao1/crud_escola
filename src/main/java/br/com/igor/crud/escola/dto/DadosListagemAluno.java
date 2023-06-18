package br.com.igor.crud.escola.dto;

import br.com.igor.crud.escola.model.Aluno;

public record DadosListagemAluno(String nome, String matricula, String responsavel, String telefone) {

	public DadosListagemAluno(Aluno aluno) {
		this(aluno.getNome(), aluno.getMatricula(), aluno.getResponsavel(), aluno.getTelefone());
	}
}
