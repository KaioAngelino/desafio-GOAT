package com.desafio.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Entity
public class Filme {

	@Getter	@Setter	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter	@Setter	@NotBlank @Column(nullable = false)
	private String nome;
	
	@Getter	@Setter	@NotBlank @Column(nullable = false, columnDefinition = "TEXT")
	private String sinopse;

	
	@Getter	@Setter @Column	private boolean isAssistido;

	@Getter @Setter	@Column
	private boolean isFavorito;
	
	@Getter @Setter @ManyToMany
    @JoinTable(name="filme_has_atores", joinColumns=
    {@JoinColumn(name="filme_id")}, inverseJoinColumns=
      {@JoinColumn(name="ator_id")})
	private List<Ator> elenco;

}
