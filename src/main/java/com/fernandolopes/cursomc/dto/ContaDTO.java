package com.fernandolopes.cursomc.dto;

import java.io.Serializable;

import com.fernandolopes.cursomc.domain.Conta;

public class ContaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public ContaDTO() {
	}
	
	public ContaDTO(Conta obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
