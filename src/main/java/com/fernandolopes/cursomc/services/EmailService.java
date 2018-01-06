package com.fernandolopes.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.fernandolopes.cursomc.domain.Cliente;
import com.fernandolopes.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
