package com.fernandolopes.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernandolopes.cursomc.domain.MovimentoConta;

@Repository
public interface MovimentoContaRepository extends JpaRepository<MovimentoConta, Integer> {

}
