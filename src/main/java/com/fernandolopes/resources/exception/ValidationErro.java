package com.fernandolopes.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationErro extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();
	
	
	public ValidationErro(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}
	
	public List<FieldMessage> getErrors(){
		return errors;
	}

	public void addError(String fielName, String messagem) {
		errors.add(new FieldMessage(fielName, messagem));
	}

	

}
