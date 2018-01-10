package com.fernandolopes.cursomc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fernandolopes.cursomc.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
	
	@Transactional(readOnly=true)
	public List<Conta> findAllByOrderByNome();

}
