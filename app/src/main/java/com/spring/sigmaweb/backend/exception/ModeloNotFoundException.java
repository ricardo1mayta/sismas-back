package com.spring.sigmaweb.backend.exception;

public class ModeloNotFoundException extends  RuntimeException{

    private static final long serialVersionUID = 1L;

    public ModeloNotFoundException(String mensaje) {
        super(mensaje);
    }
}
