package com.alura.challenge.foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.challenge.foro.application.dto.usuario.CrearUsuario;
import com.alura.challenge.foro.application.dto.usuario.DetallesUsuario;
import com.alura.challenge.foro.application.service.usuario.UsuarioService;

import jakarta.validation.Valid;

//Para poder usar este controller el usuario debe tener rol de administrado
@RestController
@RequestMapping("/usuario")
public class GestionUsuario {

    @Autowired
    private UsuarioService usuarioService;

    //crea un nuevo usuario
    @PostMapping("/crear")
    public ResponseEntity crear(@RequestBody @Valid CrearUsuario crearUsuario){

        return ResponseEntity.ok(usuarioService.CrearUsuario(crearUsuario));
    }
    //muestra todos los usuarios
    @GetMapping
    public ResponseEntity<Page<DetallesUsuario>> lista(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {
        return ResponseEntity.ok(usuarioService.listaUsuarios(paginacion));
    }

    //Cambia el estado de activo a false
    @DeleteMapping("{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        usuarioService.EliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
