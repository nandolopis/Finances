package com.fernandolopes.security;
//autenticação e geração do token JWT
//1ª classe de usuário conforme contrato do Spring Security (implements UserDetails)

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fernandolopes.domain.enums.Perfil;

public class UserSS implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorites;
	
	public UserSS() {
	}

	
	public UserSS(Integer id, String email, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorites = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
		
	}


	public Integer getId() {
		return id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorites;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean hasRole(Perfil perfil) {
		
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
		
	}
}
