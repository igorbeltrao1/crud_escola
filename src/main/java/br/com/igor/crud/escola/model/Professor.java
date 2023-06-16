package br.com.igor.crud.escola.model;

import br.com.igor.crud.escola.dto.DadosAtualizacaoProfessor;
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
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "professor")
@Entity(name = "Professor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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

	public void atualizarCadastroProfessor(@Valid DadosAtualizacaoProfessor dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.email() != null) {
			this.email = dados.email();	
		}
		if(dados.endereco() != null) {
			this.endereco.atualizarEndereco(dados.endereco());
		}
		
		
	}
	
}
