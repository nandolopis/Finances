package com.fernandolopes.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MovimentoConta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private MovimentoContaPK id = new MovimentoContaPK();
	
	private String nome;
	private Double endrada;
	private Double saida;
	
	public MovimentoConta() {
	}

	public MovimentoConta(Conta conta, String nome, Double endrada, Double saida) {
		super();
		id.setConta(conta);
		this.nome = nome;
		this.endrada = endrada;
		this.saida = saida;
	}
	
	public double getSubTotal() {
		return endrada - saida;
	}

	public MovimentoContaPK getId() {
		return id;
	}

	public void setId(MovimentoContaPK id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getEndrada() {
		return endrada;
	}

	public void setEndrada(Double endrada) {
		this.endrada = endrada;
	}

	public Double getSaida() {
		return saida;
	}

	public void setSaida(Double saida) {
		this.saida = saida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endrada == null) ? 0 : endrada.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentoConta other = (MovimentoConta) obj;
		if (endrada == null) {
			if (other.endrada != null)
				return false;
		} else if (!endrada.equals(other.endrada))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
