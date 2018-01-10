package com.fernandolopes.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandolopes.cursomc.domain.Banco;
import com.fernandolopes.cursomc.repositories.BancoRepository;

@Service
public class BancoService {
	
	@Autowired
	private BancoRepository repo;
	
	public List<Banco> findAll() {
		return repo.findAllByOrderByNome();
	}

}
