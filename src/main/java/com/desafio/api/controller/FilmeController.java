package com.desafio.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.api.model.Filme;
import com.desafio.api.model.repository.FilmeRepository;
import com.desafio.api.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private FilmeService filmeService;

	@GetMapping
	public List<Filme> listar() {
		return filmeRepository.findAll();
	}

	@GetMapping("/{filmeId}")
	public ResponseEntity<Filme> buscar(@PathVariable Long filmeId) {
		Optional<Filme> filme = filmeRepository.findById(filmeId);
		if (filme.isPresent()) {
			return ResponseEntity.ok(filme.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Filme adicionar(@Valid @RequestBody Filme filme) {
		return filmeService.salvar(filme);

	}

	@PutMapping("/{filmeId}")
	public ResponseEntity<Filme> atualizar(@Valid @PathVariable Long filmeId, @RequestBody Filme filme) {

		if (!filmeRepository.existsById(filmeId)) {
			return ResponseEntity.notFound().build();
		} else {

			filme.setId(filmeId);
			filme = filmeService.salvar(filme);

			return ResponseEntity.ok(filme);
		}

	}

	@DeleteMapping("/{filmeId}")
	public ResponseEntity<Void> deletar(@PathVariable Long filmeId) {
		if (!filmeRepository.existsById(filmeId)) {
			return ResponseEntity.notFound().build();
		} else {
			filmeService.excluir(filmeId);

			return ResponseEntity.noContent().build();
		}
	}

}
