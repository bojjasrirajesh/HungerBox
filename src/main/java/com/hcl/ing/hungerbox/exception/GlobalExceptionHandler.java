package com.hcl.ing.hungerbox.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * @author Shankar This method is used to handle all runtime exception
	 *
	 * @param exection
	 * @return ApiExceptionDto with message
	 *//*
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public final ApiExceptionDto handleAllRuntimeExceptions(RuntimeException exection) {
		String defaultMessage = exection.getMessage();
		return new ApiExceptionDto(ApiConstant.INTERNAL_SERVER_ERROR, defaultMessage);
	}

	*//**
	 * @author Shankar This method is used to handle all exception
	 *
	 * @param exection
	 * @return ApiExceptionDto with message
	 *//*
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public final ApiExceptionDto handleAllExceptions(Exception exection) {
		String defaultMessage = exection.getMessage();
		return new ApiExceptionDto(ApiConstant.INTERNAL_SERVER_ERROR, defaultMessage);
	}

	*//**
	 * @author Shankar This method is used to handle all null pointer exception
	 *
	 * @param exection
	 * @return ApiExceptionDto with message
	 *//*
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public final ApiExceptionDto handleNullPointerExceptions(NullPointerException exection) {
		String defaultMessage = exection.getMessage();
		return new ApiExceptionDto(ApiConstant.NO_ELEMENT_FOUND, defaultMessage);
	}

	


	@ExceptionHandler(NoSeatAvaliableException.class)
	public ResponseEntity<ResponseDto> noSeatAvaliableException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(LibraryUtil.NO_SEAT_AVAILABLE);
		responseDto.setStatusCode(ApplicationConstants.NOTFOUND_CODE);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
	}


	@ExceptionHandler(SufficientSeatNotAvaliableException.class)
	public ResponseEntity<ResponseDto> sufficientSeatNotAvaliableException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(LibraryUtil.EFFICIENT_SEAT_NOT_AVAILABLE);
		responseDto.setStatusCode(ApplicationConstants.NOTFOUND_CODE);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
	}*/

	
}