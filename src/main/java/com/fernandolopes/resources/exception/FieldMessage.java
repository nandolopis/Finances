package com.fernandolopes.resources.exception;

import java.io.Serializable;

public class FieldMessage  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String message;
	
	
	public FieldMessage(String fieldName, String messagem) {
		super();
		this.fieldName = fieldName;
		this.message = messagem;
	}
	
	
	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	
	
	
	
	
}
