package com.fernandolopes.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fernandolopes.cursomc.domain.Banco;
import com.fernandolopes.cursomc.dto.BancoDTO;
import com.fernandolopes.cursomc.services.BancoService;

@RestController
@RequestMapping(value="/bancos")
public class BancoResource {
	
	@Autowired
	private BancoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<BancoDTO>> findAll() {
		List<Banco> list = service.findAll();
		List<BancoDTO> listDto = list.stream().map(obj -> new BancoDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}

}
