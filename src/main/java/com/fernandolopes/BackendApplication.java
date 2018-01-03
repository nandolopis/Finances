package com.fernandolopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fernandolopes.services.S3Service;


@SpringBootApplication
public class BackendApplication implements CommandLineRunner{
	
	@Autowired
	private S3Service s3Service;
	
	

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		s3Service.uploadFile("C:\\temp\\fotos\\ana.jpg");
		
	}
		
		
}
