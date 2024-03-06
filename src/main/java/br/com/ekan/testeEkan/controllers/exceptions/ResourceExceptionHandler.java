package br.com.ekan.testeEkan.controllers.exceptions;

import br.com.ekan.testeEkan.service.exceptions.DataIntegrityViolationException;
import br.com.ekan.testeEkan.service.exceptions.ObjectNotFoundExceptions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundExceptions.class)
    public ResponseEntity<StandardError> objectNotfoundException(ObjectNotFoundExceptions exception, HttpServletRequest request){
        StandardError erro = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object not found", exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException exception, HttpServletRequest request){
        StandardError erro = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Object not found", exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
