package br.com.crud.exception;

public class GenericNotFoundException extends RuntimeException {

    private static final String message = "Resource not found";

    public GenericNotFoundException() {
        super(message);
    }

    public GenericNotFoundException(String message) {
        super(message);
    }
}
