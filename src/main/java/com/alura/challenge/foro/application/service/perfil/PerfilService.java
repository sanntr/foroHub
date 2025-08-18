package com.alura.challenge.foro.application.service.perfil;


import com.alura.challenge.foro.domain.model.perfil.Perfil;
import com.alura.challenge.foro.domain.model.perfil.TiposPerfil;
import com.alura.challenge.foro.domain.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository repository;

    @Transactional
    public Perfil crearPerfil(String perfilTesto){
        var perfil=repository.findByPerfil(TiposPerfil.valueOf(perfilTesto));
        if (perfil.isEmpty()){
            return repository.save(new Perfil(TiposPerfil.valueOf(perfilTesto)));
        }
        return perfil.get();
    }
}
