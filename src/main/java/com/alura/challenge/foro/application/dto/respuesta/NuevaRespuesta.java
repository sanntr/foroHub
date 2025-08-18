package com.alura.challenge.foro.application.dto.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NuevaRespuesta(
    @NotBlank
    String mensaje,
    @NotNull
    Long topicoId,
    @NotNull
    Long autorId
) {}
