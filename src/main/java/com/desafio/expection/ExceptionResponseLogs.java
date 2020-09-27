package com.desafio.expection;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ExceptionResponseLogs {

	@Getter
	@Setter
	private Integer status;
	@Getter
	@Setter
	private LocalDateTime dataHora;
	@Getter
	@Setter
	private String descricao;

	@Getter
	@Setter
	private List<Campo> campos;

	public static class Campo {

		
		@Getter
		@Setter
		private String nome;
		@Getter
		@Setter
		private String mensagem;
		
		public Campo(String nome, String mensagem) {
			super();
			this.nome = nome;
			this.mensagem = mensagem;
		}

	}
}
