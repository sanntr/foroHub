package com.alura.challenge.foro.domain.model.perfil;


public enum TiposPerfil {
        ADMINISTRADOR("Administrador"),
    MODERADOR("Moderador"),
    PROFESOR("Profesor"),
    ESTUDIANTE("Estudiante"),
    INVITADO("Invitado");

    private String texto;

    TiposPerfil(String texto){
        this.texto=texto;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}
