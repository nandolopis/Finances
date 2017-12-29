package com.fernandolopes.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fernandolopes.domain.enums.EstadoPagamento;
@Entity
@JsonTypeName("pagamentoComBoleto") //anotaçao para preparar o Json para inserir um pedido 
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado,Pedido pedido , Integer numeroDeParcelas ) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
}
