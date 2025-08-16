package com.alura.challenge.foro.infrastructure.exception;

public class ValidacionException extends RuntimeException{

    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}
