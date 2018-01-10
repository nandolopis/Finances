package com.fernandolopes.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernandolopes.cursomc.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
