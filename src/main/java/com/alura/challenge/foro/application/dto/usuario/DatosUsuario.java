package com.alura.challenge.foro.application.dto.usuario;

import jakarta.validation.constraints.NotBlank;


public record DatosUsuario(
        @NotBlank
        String nombreUsuario,
        @NotBlank
        String contrasena,
        String role
) {
}
