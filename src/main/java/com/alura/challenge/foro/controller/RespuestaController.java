package com.alura.challenge.foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.challenge.foro.application.dto.respuesta.DetallesRespuesta;
import com.alura.challenge.foro.application.dto.respuesta.NuevaRespuesta;
import com.alura.challenge.foro.application.service.respuesta.RespuestaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @PostMapping
    public ResponseEntity<DetallesRespuesta> crearRespuesta(
            @RequestBody @Valid NuevaRespuesta datos,
            UriComponentsBuilder uriBuilder
    ) {
        var respuesta = respuestaService.crearRespuesta(datos);
        var uri = uriBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallesRespuesta> buscarRespuesta(@PathVariable Long id) {
        var respuesta = respuestaService.buscarRespuesta(id);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/respuestas/{id}")
    public ResponseEntity<Page<DetallesRespuesta>> listarRespuestasPorTopico(@PathVariable Long id,
            @PageableDefault(size = 10, sort = {"fechaCreacion"}) Pageable paginacion
    ) {
        var respuestas = respuestaService.buscarRespuestasPorTopico(id,paginacion);
        return ResponseEntity.ok(respuestas);
    }
}
