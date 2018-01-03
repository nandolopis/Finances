package com.fernandolopes.services;
//método que retorna o usuário logado

import org.springframework.security.core.context.SecurityContextHolder;

import com.fernandolopes.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
				try {
						return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					}
					catch (Exception e) {
						return null;
			 		}
				}

	
}