package com.fernandolopes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fernandolopes.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Transactional(readOnly=true) //nao nessecita se uma trasação de banco de dados, deixando mais rapido
	Cliente findByEmail(String email);

}
