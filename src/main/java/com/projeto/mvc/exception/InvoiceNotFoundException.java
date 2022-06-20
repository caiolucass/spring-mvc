package com.projeto.mvc.exception;

public class InvoiceNotFoundException extends RuntimeException{

    private static final long serialVersion = 1L;

    public InvoiceNotFoundException() {
        super();
    }

    public InvoiceNotFoundException(String customMessage) {
        super(customMessage);
    }
}
