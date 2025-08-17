package com.alura.challenge.foro.application.dto.usuario;

public record DetallesUsuario(
        Long id,
        String nombre,
        String correo,
        String perfil
) {
}
