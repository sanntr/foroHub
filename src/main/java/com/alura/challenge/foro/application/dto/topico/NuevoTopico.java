package com.alura.challenge.foro.application.dto.topico;

public record NuevoTopico(
    String titulo,
    String mensaje,
    String correo_autor,
    Long curso_id
) {
}
