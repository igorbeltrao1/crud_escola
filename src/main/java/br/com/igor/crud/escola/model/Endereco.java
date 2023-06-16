package br.com.igor.crud.escola.model;

import br.com.igor.crud.escola.dto.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Endereco {
	
	public Endereco(DadosEndereco endereco) {
		this.logradouro = endereco.logradouro();
		this.bairro = endereco.bairro();
		this.cep = endereco.cep();
		this.complemento = endereco.complemento();
		this.cidade = endereco.cidade();
		this.numero = endereco.numero();
		this.estado = endereco.estado();
	}
	
	public Endereco() {
		
	}
	
	private String logradouro;

	private String cep;
	
	private String bairro;

	private String cidade;

	private String estado;

	private String complemento;
	
	private String numero;
	
	public void atualizarEndereco (DadosEndereco dados) {
		if (dados.logradouro() != null) {
			this.logradouro = dados.logradouro();
		}
		if (dados.cep() != null) {
			this.cep = dados.cep();
		}
		if (dados.bairro() != null) {
			this.bairro = dados.bairro();
		}
		if (dados.cidade() != null) {
			this.cidade = dados.cidade();
		}
		if (dados.estado() != null) {
			this.estado = dados.estado();
		}
		if (dados.complemento() != null) {
			this.complemento = dados.complemento();
		}
		if (dados.numero() != null) {
			this.numero = dados.numero();
		}
		
		
		
	}
	

}
