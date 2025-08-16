package com.alura.challenge.foro.controller;

import com.alura.challenge.foro.application.dto.usuario.DatosUsuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @PostMapping
    public ResponseEntity iniciarSecion(@RequestBody @Valid DatosUsuario datosUsuario){
        return null;
    }
}
