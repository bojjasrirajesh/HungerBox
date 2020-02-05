package com.hcl.ing.hungerbox.exception;

public class DeleteVendorException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private final String message;
	
	public DeleteVendorException(String message) {
		super(message);
		this.message=message;
	}
}
