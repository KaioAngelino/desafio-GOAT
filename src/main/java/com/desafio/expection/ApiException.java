package com.desafio.expection;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiException extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ArrayList<ExceptionResponseLogs.Campo> campos = new ArrayList<ExceptionResponseLogs.Campo>();

		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String mensagemErro = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			campos.add(new ExceptionResponseLogs.Campo(nome, mensagemErro));

		}

		ExceptionResponseLogs exception = new ExceptionResponseLogs();
		exception.setStatus(status.value());
		exception.setDescricao("Existem campos inválidos! \nFaça o preenchimento corretamente e tente novamente.");
		exception.setDataHora(LocalDateTime.now());
		exception.setCampos(campos);

		return super.handleExceptionInternal(ex, exception, headers, status, request);
	}

}
