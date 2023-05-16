package br.com.igor.crud.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igor.crud.escola.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>  {

}
