package com.desafio.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.api.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	List<Filme> findByNome(String nome);
	List<Filme> findByNomeContaining(String nome);
	
	

}
