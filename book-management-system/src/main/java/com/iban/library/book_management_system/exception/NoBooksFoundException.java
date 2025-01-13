package com.iban.library.book_management_system.exception;

public class NoBooksFoundException extends RuntimeException{

    public NoBooksFoundException(String message) {
        super(message);
    }
}
