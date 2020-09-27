package com.desafio.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Entity
public class Ator {

	@Getter	@Setter	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter	@Setter	@NotBlank @Column(nullable = false)
	private String nome;
	
	@Getter	@Setter @Column(columnDefinition="char(1)")
	private String sexo;
	
	@Getter	@Setter @Column
	private int idade;
	
	@Getter @Setter @ManyToMany(mappedBy="elenco")
	private List<Filme> filmes;
}
