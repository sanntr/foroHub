package com.alura.challenge.foro.application.service.topico;

import com.alura.challenge.foro.application.dto.topico.DetallesTopico;
import com.alura.challenge.foro.application.dto.topico.NuevoTopico;
import com.alura.challenge.foro.domain.model.topico.Topico;
import com.alura.challenge.foro.domain.repository.CursoReopsitory;
import com.alura.challenge.foro.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Convertirtopico {

    //Repository
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoReopsitory cursoRepository;


    //--------------------------------------Metodos---------------------------------------------------

    //convierte el dto NuevoTopico a  la entidad Topico
    public Topico generarTopico(NuevoTopico topico){
        return new Topico(
                topico.titulo(),
                topico.mensaje(),
                usuarioRepository.findByEmail(topico.correo_autor()),
                cursoRepository.FindById(topico.curso_id())
        );
    }

    //convierte la entidad topico a el dto DetallesTopico
    public DetallesTopico topicoaDetallesTopico(Topico topico){
        return new DetallesTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor().getNombre()
        );
    }

}
