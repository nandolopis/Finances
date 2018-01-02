package com.fernandolopes.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.fernandolopes.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}") // para pegar o valo do arquivo properties
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
		
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmato! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis())); //System.currentTimeMillis() para garantir que seja pego a data do sistema
		sm.setText(obj.toString());
		
		return sm;
	}

}
