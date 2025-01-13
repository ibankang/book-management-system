package com.iban.library.book_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Handle Book Not Found Exception
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    //Handle Book Not Found by search Exception
    @ExceptionHandler(NoBooksFoundException.class)
    public ResponseEntity<String> handleNoBooksFoundException(NoBooksFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    //Handle validation Errors (e.g, empty title or price >0)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    //Handle Other custom exceptions
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> handleInvalidInputException(InvalidInputException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

    }

    //Handle generic Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex){
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
