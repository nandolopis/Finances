package com.fernandolopes.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandolopes.cursomc.domain.Conta;
import com.fernandolopes.cursomc.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repo;
	
	public List<Conta> findAll() {
		return repo.findAllByOrderByNome();
	}

}
