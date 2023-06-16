package br.com.igor.crud.escola.dto;

import br.com.igor.crud.escola.enumerate.Disciplinas;
import br.com.igor.crud.escola.model.Professor;

public record DadosListagemProfessor(
		String nome,
		String telefone,
		Disciplinas	disciplina) {
	
	public DadosListagemProfessor(Professor professor) {
		this(professor.getNome(), professor.getTelefone(), professor.getDisciplina());
	}
	
	

}
