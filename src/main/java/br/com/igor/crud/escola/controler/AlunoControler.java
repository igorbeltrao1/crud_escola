package br.com.igor.crud.escola.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.igor.crud.escola.dto.DadosCadastroAluno;
import br.com.igor.crud.escola.dto.DadosDetalhamentoAluno;
import br.com.igor.crud.escola.model.Aluno;
import br.com.igor.crud.escola.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoControler {

	@Autowired
	private AlunoRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid
			DadosCadastroAluno dados, UriComponentsBuilder uriBuilder) {
		
		var aluno = new Aluno(dados);
		
		repository.save(aluno);
		
		var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId())
				.toUri();
		
		return ResponseEntity.created(uri)
				.body(new DadosDetalhamentoAluno(aluno));
		
	}
	
}
