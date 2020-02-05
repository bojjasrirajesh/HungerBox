package com.hcl.ing.hungerbox.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AddVendorException.class)
    public ResponseEntity<ErrorResponse> addVendorException(AddVendorException ex) {
        
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessgage(ex.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setDateAndTime(LocalDateTime.now());
		
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(DeleteVendorException.class)
    public ResponseEntity<ErrorResponse> deleteVendorException(DeleteVendorException ex) {
        
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessgage(ex.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setDateAndTime(LocalDateTime.now());
		
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}