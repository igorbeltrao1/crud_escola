package br.com.igor.crud.escola.dto;

import br.com.igor.crud.escola.enumerate.Disciplinas;
import br.com.igor.crud.escola.model.Endereco;
import br.com.igor.crud.escola.model.Professor;

public record DadosDetalhamentoProfessor(
		
		Long id,
		
		 String nome,
	
		 String cpf,
		
		 String telefone,
	 
		 Disciplinas disciplina,
		
		 String email,
	
		 boolean filhos,
		
		 int qtdeFilhos,
		
		 Endereco endereco
		
		
		) {

	public DadosDetalhamentoProfessor(Professor professor) {
		
		this (professor.getId(), professor.getNome(), professor.getCpf(), professor.getTelefone(),
				professor.getDisciplina(), professor.getEmail(), professor.isFilhos(),
				professor.getQtdeFilhos(), professor.getEndereco());
		
	}

}
