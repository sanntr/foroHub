package com.alura.challenge.foro.application.dto.usuario;

import com.alura.challenge.foro.domain.model.perfil.TiposPerfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearUsuario(

        @NotBlank
        String nombre,

        @NotBlank
        String email,

        @NotBlank
        String contrasena,
        @NotNull
        String perfil
) {
}
