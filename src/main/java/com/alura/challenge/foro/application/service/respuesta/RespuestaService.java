package com.alura.challenge.foro.application.service.respuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alura.challenge.foro.application.dto.respuesta.DetallesRespuesta;
import com.alura.challenge.foro.application.dto.respuesta.NuevaRespuesta;
import com.alura.challenge.foro.domain.repository.RespuestaRepository;
import com.alura.challenge.foro.infrastructure.exception.ValidacionException;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private ConvertirRespuesta convertirRespuesta;

    @Transactional
    public DetallesRespuesta crearRespuesta(NuevaRespuesta datos) {
        var nuevaRespuesta = convertirRespuesta.generarRespuesta(datos);
        respuestaRepository.save(nuevaRespuesta);
        return convertirRespuesta.respuestaADetallesRespuesta(nuevaRespuesta);
    }

    public DetallesRespuesta buscarRespuesta(Long id) {
        return respuestaRepository.findById(id)
                .map(respuesta -> convertirRespuesta.respuestaADetallesRespuesta(respuesta))
                .orElseThrow(() -> new ValidacionException("No existe esa respuesta"));
    }

    public Page<DetallesRespuesta> buscarRespuestasPorTopico(Long topicoId, Pageable paginacion) {
        return respuestaRepository.findByTopicoId(topicoId, paginacion)
                .map(respuesta -> convertirRespuesta.respuestaADetallesRespuesta(respuesta));
    }
}
