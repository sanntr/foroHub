package com.alura.challenge.foro.application.service.topico;

import com.alura.challenge.foro.application.dto.topico.DetallesTopico;
import com.alura.challenge.foro.application.dto.topico.NuevoTopico;
import com.alura.challenge.foro.domain.repository.TopicoRepository;
import com.alura.challenge.foro.infrastructure.exception.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        if (topico.isPresent()){
            return convertirtopico.topicoaDetallesTopico(topico.get());
        }
        topicoRepository.findAll().stream().forEach(System.out::println);
        throw new ValidacionException("No existe ese topico");
    }

    //Metodo para eliminar(Cambiar el estado del topico a false )
    @Transactional
    public void eliminarTopico(Long id){
        var topico=topicoRepository.findById(id);
        topico.get().setActivo(false);
    }

    //Metodo para lista topicos
    public Page<DetallesTopico> listarTopico(Pageable pageable){
        return  topicoRepository.findAllByActivoTrue(pageable)
                .map(e->convertirtopico.topicoaDetallesTopico(e)
        );

    }
}
