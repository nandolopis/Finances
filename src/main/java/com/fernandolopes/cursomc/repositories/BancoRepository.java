package com.fernandolopes.cursomc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fernandolopes.cursomc.domain.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {
	
	@Transactional(readOnly=true)
	public List<Banco> findAllByOrderByNome();

}
