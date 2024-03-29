package br.com.igor.crud.escola.controler;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.igor.crud.escola.dto.DadosAtualizacaoAluno;
import br.com.igor.crud.escola.dto.DadosCadastroAluno;
import br.com.igor.crud.escola.dto.DadosDetalhamentoAluno;
import br.com.igor.crud.escola.dto.DadosListagemAluno;
import br.com.igor.crud.escola.model.Aluno;
import br.com.igor.crud.escola.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	private static final Logger logger = Logger.getLogger(AlunoController.class.getName());
	@Autowired
	private AlunoRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity cadastrarAluno(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uriBuilder) {

		logger.info(" >>>> [AlunoController] - cadastrar");
		var aluno = new Aluno(dados);

		repository.save(aluno);

		var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();

		return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));

	}

	@GetMapping
	public ResponseEntity <Page<DadosListagemAluno>> listarAluno (@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
		logger.info(" >>>> [AlunoController] - listarAluno");
		var aluno = repository.findAll(paginacao).map(DadosListagemAluno::new);
		
		return ResponseEntity.ok(aluno);
				
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity atualizarAluno (DadosAtualizacaoAluno dados) {
		logger.info(" >>>> [AlunoController] - atualizarAluno");
		var aluno = repository.getReferenceById(dados.id());
		aluno.atualizacaoCadastroAluno(dados);
		return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluirAluno (@PathVariable Long id) {
		logger.info(" >>>> [AlunoController] - excluirAluno");
		repository.deleteById(id);
		
		return ResponseEntity.ok().build();
		
	}

}
