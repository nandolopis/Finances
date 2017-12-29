package com.fernandolopes.services.exception.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.fernandolopes.domain.Cliente;
import com.fernandolopes.dto.ClienteDTO;
import com.fernandolopes.repositories.ClienteRepository;
import com.fernandolopes.resources.exception.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO>{
	
	@Autowired
	private HttpServletRequest request; //HttpServletRequest permite obter o parametro para achar o id exitente
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context ) {
		@SuppressWarnings("unused")
		Map<String, String> map = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);//para armasenar os atributos na requisição - chave/valor
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		//inclua os teste aqui, inserindo erro da lista
		
				
 		//validação email
 		Cliente aux = repo.findByEmail(objDto.getEmail());
 		if (aux != null && !aux.getId().equals(uriId)) {
 			 			list.add(new FieldMessage("email", "Email já existente"));
 			 		}

		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
				.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
