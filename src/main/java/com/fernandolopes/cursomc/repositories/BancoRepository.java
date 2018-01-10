package com.fernandolopes.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernandolopes.cursomc.domain.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {

}
