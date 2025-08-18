package com.alura.challenge.foro.application.dto.usuario;

import com.alura.challenge.foro.domain.model.perfil.TiposPerfil;

public record DetallesUsuario(
        Long id,
        String nombre,
        String correo,
        TiposPerfil perfil
) {
}
