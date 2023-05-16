package br.com.igor.crud.escola.model;



import br.com.igor.crud.escola.dto.DadosCadastroAluno;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_alunos")
@Entity(name = "Aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "responsável")
	private String responsavel;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "matricula")
	private String matricula;

	public Aluno() {
	}

	@Embedded
	private Endereco endereco;
	
	public Aluno(DadosCadastroAluno dados) {
		this.nome = dados.nome();
		this.telefone = dados.telefone();
		this.email = dados.email();
		this.matricula = dados.matricula();
		this.responsavel = dados.responsavel();
		this.endereco = new Endereco(dados.endereco());
	}
	
}
