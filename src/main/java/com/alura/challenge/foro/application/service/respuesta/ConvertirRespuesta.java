package com.alura.challenge.foro.application.service.respuesta;

import com.alura.challenge.foro.application.dto.respuesta.DetallesRespuesta;
import com.alura.challenge.foro.application.dto.respuesta.NuevaRespuesta;
import com.alura.challenge.foro.application.dto.usuario.DetallesAutor;
import com.alura.challenge.foro.domain.model.respuesta.Respuesta;
import com.alura.challenge.foro.domain.repository.TopicoRepository;
import com.alura.challenge.foro.domain.repository.UsuarioRepository;
import com.alura.challenge.foro.infrastructure.exception.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertirRespuesta {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public Respuesta generarRespuesta(NuevaRespuesta datos) {
        var topico = topicoRepository.findById(datos.topicoId())
                .orElseThrow(() -> new ValidacionException("No existe el tópico con ID: " + datos.topicoId()));
        
        var autor = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new ValidacionException("No existe el usuario con ID: " + datos.autorId()));

        return new Respuesta(
                null,
                datos.mensaje(),
                topico,
                null,
                autor
        );
    }

    public DetallesRespuesta respuestaADetallesRespuesta(Respuesta respuesta) {
        return new DetallesRespuesta(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                new DetallesAutor(
                        respuesta.getAutor().getId(),
                        respuesta.getAutor().getNombre(),
                        respuesta.getAutor().getPerfil().getPerfil().toString()
                ),
                respuesta.getTopico().getId()
        );
    }
}
