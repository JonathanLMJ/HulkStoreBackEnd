package com.hulkstore.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public void handlerException(ResourceNotFoundException e, HttpServletResponse response) throws IOException{
		response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
		
	}

}
