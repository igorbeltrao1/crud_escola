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

import br.com.igor.crud.escola.dto.DadosAtualizacaoProfessor;
import br.com.igor.crud.escola.dto.DadosCadastroProfessor;
import br.com.igor.crud.escola.dto.DadosDetalhamentoProfessor;
import br.com.igor.crud.escola.dto.DadosListagemProfessor;
import br.com.igor.crud.escola.model.Professor;
import br.com.igor.crud.escola.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	private static final Logger logger = Logger.getLogger(ProfessorController.class.getName());

	@Autowired
	private ProfessorRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity cadastrarProfessor(@RequestBody @Valid DadosCadastroProfessor dados, UriComponentsBuilder uriBuilder) {
		logger.info(" >>>> [ProfessorController] - cadastrarProfessor");
		var professor = new Professor(dados);

		repository.save(professor);

		var uri = uriBuilder.path("/professor/{id}").buildAndExpand(professor.getId()).toUri();

		return ResponseEntity.created(uri).body(new DadosDetalhamentoProfessor(professor));

	}

	@GetMapping
	public ResponseEntity<Page<DadosListagemProfessor>> listarProfessor(
			@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
		logger.info(" >>>> [ProfessorController] - listarProfessor");

		var page = repository.findAll(paginacao).map(DadosListagemProfessor::new);

		return ResponseEntity.ok(page);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity atualizarProfessor(@RequestBody @Valid DadosAtualizacaoProfessor dados) {
		logger.info(" >>>> [ProfessorController] - atualizarProfessor");
		var professor = repository.getReferenceById(dados.id());
		professor.atualizarCadastroProfessor(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deletarProfessor(@PathVariable Long id) {
		logger.info(" >>>> [ProfessorController] - deletarProfessor");
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
