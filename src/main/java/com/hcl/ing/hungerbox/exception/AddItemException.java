package com.hcl.ing.hungerbox.exception;

public class AddItemException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private final String message;
	
	public AddItemException(String message) {
		super(message);
		this.message=message;
	}
}
