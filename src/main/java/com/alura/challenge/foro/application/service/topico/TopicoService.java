package com.alura.challenge.foro.application.service.topico;

import com.alura.challenge.foro.application.dto.topico.DetallesTopico;
import com.alura.challenge.foro.application.dto.topico.NuevoTopico;
import com.alura.challenge.foro.domain.repository.TopicoRepository;
import com.alura.challenge.foro.infrastructure.exception.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    //Repository
    @Autowired
    private TopicoRepository topicoRepository;

    //clase auxiliar
    //añade diferentes funcionalidades repetitivas
    @Autowired
    private Convertirtopico convertirtopico;

    //Metodo para crear un nuevo topico
    @Transactional
    public DetallesTopico CrearTopico(NuevoTopico topico){
        var nuevoTopico=convertirtopico.generarTopico(topico);

        if(topicoRepository.topicoExiste(topico.titulo()).isPresent()){
            throw new ValidacionException("topico ya existente");
        }

        topicoRepository.save(nuevoTopico);
        return convertirtopico.topicoaDetallesTopico(nuevoTopico);
    }

    //Metodo para mostrar un solo topico
    public DetallesTopico buscarTopico(Long id){
        var topico= topicoRepository.findById(id);
        topico.ifPresent(
                value -> convertirtopico.topicoaDetallesTopico(value)
        );
        throw new ValidacionException("No existe ese topico");
    }

}
