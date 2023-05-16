package br.com.igor.crud.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igor.crud.escola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
