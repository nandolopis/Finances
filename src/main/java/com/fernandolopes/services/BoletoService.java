package com.fernandolopes.services;

//serviço de geraçao de boleto para 7 dias
//posteriormente podendo implanta um web service aqui para gerar o boleto automaticamente 

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.fernandolopes.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataPagamento(cal.getTime());
	}

}
