package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.model.ErrorResponseDTO;

import customexception.FieldRequiredException;

@ControllerAdvice
public class controllerAdvisor extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest request) {
		ErrorResponseDTO error = new ErrorResponseDTO();
		error.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("khong duoc chia cho 0");
		error.setDetail(details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<Object> handleFielRequirexception(FieldRequiredException ex, WebRequest request){
		ErrorResponseDTO error = new ErrorResponseDTO();
		error.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("Check lai number va name");
		error.setDetail(details);
        return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
	}
}
