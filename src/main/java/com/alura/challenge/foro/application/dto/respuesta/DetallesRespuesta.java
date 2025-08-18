package com.alura.challenge.foro.application.dto.respuesta;

import java.time.LocalDateTime;

import com.alura.challenge.foro.application.dto.usuario.DetallesAutor;

public record DetallesRespuesta(
    Long id,
    String mensaje,
    LocalDateTime fechaCreacion,
    DetallesAutor autor,
    Long topicoId
) {}
