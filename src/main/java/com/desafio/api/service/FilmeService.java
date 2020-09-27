package com.desafio.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.api.model.Filme;
import com.desafio.api.model.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;

	public Filme salvar(Filme filme) {
		return filmeRepository.save(filme);
	}

	public void excluir(Long filmeId) {
		filmeRepository.deleteById(filmeId);
	}

	public List<Filme> listarTodosFilmes(Filme filme) {
		return filmeRepository.findAll();
	}

}
