package br.com.igor.crud.escola.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity tratarErro400() {
		return ResponseEntity.notFound().build();

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity tratarErro404(MethodArgumentNotValidException ex) {

		var erro = ex.getFieldErrors();

		return ResponseEntity.badRequest().body(erro.stream().map(DadosErrosDeValidacao::new));
	}

	private record DadosErrosDeValidacao(String campo, String menssagem) {
		public DadosErrosDeValidacao(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
}
