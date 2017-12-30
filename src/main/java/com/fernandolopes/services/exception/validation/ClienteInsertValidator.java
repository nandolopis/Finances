package com.fernandolopes.services.exception.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fernandolopes.domain.Cliente;
import com.fernandolopes.domain.enums.TipoCliente;
import com.fernandolopes.dto.ClienteNewDTO;
import com.fernandolopes.repositories.ClienteRepository;
import com.fernandolopes.resources.exception.FieldMessage;
import com.fernandolopes.services.exception.validation.utils.BR;


public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO>{
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}
	
	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context ) {
		List<FieldMessage> list = new ArrayList<>();
		//inclua os teste aqui, inserindo erro da lista
		
		//#validação de cpf e cnpj
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
		 			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		 		}
		 
 		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
 			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
 		
 		}
 		//validação email
 		Cliente aux = repo.findByEmail(objDto.getEmail());
 		if (aux != null) {
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
