package br.com.univesp.pi;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class StockResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
/*
    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
*/
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {

        //String error = "The following Resource ID hasn't been found: " + e.getMessage();
        //ErrorTemplate apiError = new ErrorTemplate(HttpStatus.NOT_FOUND, e.getLocalizedMessage(), error);
        //ResponseEntity<Object> test = new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());

        return ErrorResponse.builder(e, HttpStatus.NOT_FOUND, e.getMessage())
                .title("Resource not found")
                .type(URI.create(((ServletWebRequest) request).getRequest().getRequestURL().toString()))
                .detail("The following Resource ID hasn't been found in the Database: " + e.getMessage())
                .property("errorCategory", "Database")
                .property("timestamp", Instant.now())
                .build();

    }
    /*
    @ExceptionHandler(DuplicatedProductException.class)
    public ErrorResponse handleConstraintViolationException(ResourceNotFoundException e, WebRequest request) {

        String cu;

        return ErrorResponse.builder(e, HttpStatus.BAD_REQUEST, e.getMessage())
                .title("Constraint Violation")
                .type(URI.create(((ServletWebRequest) request).getRequest().getRequestURL().toString()))
                .detail("The following Product already exists in the Database")
                .property("errorCategory", "Database")
                .property("timestamp", Instant.now())
                .build();

    }

     */


}