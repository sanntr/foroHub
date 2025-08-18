package com.alura.challenge.foro.controller;

import com.alura.challenge.foro.application.dto.topico.CambioDatosTopico;
import org.springframework.hateoas.EntityModel;
import com.alura.challenge.foro.application.dto.topico.DetallesTopico;
import com.alura.challenge.foro.application.dto.topico.NuevoTopico;
import com.alura.challenge.foro.application.dto.topico.PaginaDetallesTopico;
import com.alura.challenge.foro.application.service.topico.TopicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@SecurityRequirement(name ="bearer-key")
@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private PagedResourcesAssembler<DetallesTopico> pagedResourscesAssembler;

    @Autowired
    private TopicoService topicoService;
    @Autowired
    private PaginaDetallesTopico paginaDetallesTopico;


    //Crea nuevo topico si se cumplen las reglas establecidas
    @PostMapping
    public ResponseEntity crear(@RequestBody @Valid NuevoTopico nuevoTopico, UriComponentsBuilder uriComponentsBuilder){
        var topico=topicoService.CrearTopico(nuevoTopico);
        var uri=uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(topico.id()).toUri();
        return ResponseEntity.created(uri).body(topico);
    }

    //Muestra un unico topico
    @GetMapping("/{id}")
    public ResponseEntity mostrar(@PathVariable Long id){
        return ResponseEntity.ok(topicoService.buscarTopico(id));
    }

    //Eliminar topico
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }

    //Mostrar todos los topicos
    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<DetallesTopico>>>  lista(@PageableDefault(size = 10,sort = {"titulo"})Pageable pageable){
        Page<DetallesTopico> pagina=topicoService.listarTopico(pageable);
        var page=pagedResourscesAssembler.toModel(pagina,paginaDetallesTopico);
        return ResponseEntity.ok(page);
    }

    //Cambiar Datos de un topico, solo se puede cambiar el titulo y el mensaje
    @PostMapping("/{id}")
    public ResponseEntity modificar(@PathVariable Long id, @RequestBody CambioDatosTopico cambioDatosTopico){
        return ResponseEntity.ok(topicoService.cambiarDatos(id,cambioDatosTopico));
    }


}
