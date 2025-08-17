package com.alura.challenge.foro.controller;

import com.alura.challenge.foro.application.dto.topico.NuevoTopico;
import com.alura.challenge.foro.application.service.topico.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity crear(@RequestBody @Valid NuevoTopico nuevoTopico, UriComponentsBuilder uriComponentsBuilder){
        var topico=topicoService.CrearTopico(nuevoTopico);
        var uri=uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(topico.id()).toUri();
        return ResponseEntity.created(uri).body(topico);
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrar(@PathVariable Long id){
        return ResponseEntity.ok(topicoService.buscarTopico(id));
    }


}
