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
	
	
	

}
