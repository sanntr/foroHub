package com.alura.challenge.foro.application.dto.topico;

import java.time.LocalDateTime;

public record DetallesTopico(
        Long id,
        String titulo,
        String texto,
        LocalDateTime fechaCreacion,
        String autor
) {
}
