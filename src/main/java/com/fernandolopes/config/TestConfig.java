package com.fernandolopes.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernandolopes.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbServer;
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbServer.instantiateTestDatabase();
		return true;
	}

}
