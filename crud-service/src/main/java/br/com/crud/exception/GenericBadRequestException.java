package br.com.crud.exception;

public class GenericBadRequestException extends RuntimeException {

    private static final String MESSAGE = "Requisição incorreta";

    public GenericBadRequestException() {
        super(MESSAGE);
    }

    public GenericBadRequestException(String message) {
        super(MESSAGE + ": " + message);
    }
}
