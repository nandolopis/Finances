package com.fernandolopes.services;
//autenticação e geração do token JWT
//2º classe de serviço conforme contrato do Spring Security (implements UserDetailsService)

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fernandolopes.domain.Cliente;
import com.fernandolopes.repositories.ClienteRepository;
import com.fernandolopes.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private ClienteRepository clienterepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Cliente cli = clienterepository.findByEmail(email);
		if (cli == null) {
			throw new UsernameNotFoundException(email); //exceção do spring security
		}
		
		return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}
	

}
