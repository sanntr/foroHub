package com.alura.challenge.foro.controller;

import com.alura.challenge.foro.application.dto.usuario.DatosUsuario;
import com.alura.challenge.foro.domain.model.usuario.Usuario;
import com.alura.challenge.foro.infrastructure.security.token.DatosToken;
import com.alura.challenge.foro.infrastructure.security.token.TokenService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity iniciarSecion(@RequestBody @Valid DatosUsuario datosUsuario){
        var token = new UsernamePasswordAuthenticationToken(datosUsuario.correo(),datosUsuario.contrasena());
        var autentication= authenticationManager.authenticate(token);
        return ResponseEntity.ok(new DatosToken(tokenService.crearToken((Usuario) autentication.getPrincipal())));
    }
}
