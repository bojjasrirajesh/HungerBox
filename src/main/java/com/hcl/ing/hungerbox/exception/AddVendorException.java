package com.hcl.ing.hungerbox.exception;

public class AddVendorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private final String message;
	
	public AddVendorException(String message) {
		super(message);
		this.message=message;
	}
	
}
