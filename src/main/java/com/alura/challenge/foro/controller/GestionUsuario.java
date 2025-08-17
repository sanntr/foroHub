package com.alura.challenge.foro.controller;

import com.alura.challenge.foro.application.dto.usuario.CrearUsuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class GestionUsuario {

    @PostMapping("/crear")
    public ResponseEntity crear(@RequestBody @Valid CrearUsuario crearUsuario){
        return ResponseEntity.ok().build();
    }

}
