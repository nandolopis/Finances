package com.fernandolopes.services;

import org.springframework.mail.SimpleMailMessage;

import com.fernandolopes.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
