package br.com.igor.crud.escola.model;

import br.com.igor.crud.escola.dto.DadosCadastroProfessor;
import br.com.igor.crud.escola.enumerate.Disciplinas;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Professor {

	@Column(name = "nome")
	private String nome;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "telefone")
	private String telefone;

	
	@Column(name = "disciplina")
	@Enumerated(EnumType.STRING)
	private Disciplinas disciplina;

	@Column(name = "email")
	private String email;

	@Column(name = "filhos(S/n)")
	private boolean filhos;

	@Column(name = "qtdeFilhos")
	private int qtdeFilhos;

	@Embedded
	private Endereco endereco;

	public Professor() {

	}

	public Professor(DadosCadastroProfessor dadosProfessor) {
		this.nome = dadosProfessor.nome();
		this.cpf = dadosProfessor.cpf();
		this.telefone = dadosProfessor.telefone();
		this.disciplina = dadosProfessor.disciplina();
		this.email = dadosProfessor.email();
		this.filhos = dadosProfessor.filhos();
		this.qtdeFilhos =  dadosProfessor.qtdeFilhos();
		this.endereco = new Endereco(dadosProfessor.endereco());
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Disciplinas getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplinas disciplina) {
		this.disciplina = disciplina;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isFilhos() {
		return filhos;
	}

	public void setFilhos(boolean filhos) {
		this.filhos = filhos;
	}

	public int getQtdeFilhos() {
		return qtdeFilhos;
	}

	public void setQtdeFilhos(int qtdeFilhos) {
		this.qtdeFilhos = qtdeFilhos;
	}

}
