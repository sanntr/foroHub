package com.alura.challenge.foro.application.dto.topico;

import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class PaginaDetallesTopico implements RepresentationModelAssembler < DetallesTopico,EntityModel<DetallesTopico>> {
    @Override
    public EntityModel<DetallesTopico> toModel(@NotNull DetallesTopico detallesTopico) {
        return EntityModel.of(detallesTopico);
    }
}

