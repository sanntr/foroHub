package com.alura.challenge.foro.domain.repository;

import com.alura.challenge.foro.domain.model.perfil.Perfil;
import com.alura.challenge.foro.domain.model.perfil.TiposPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Perfil findByPerfil(TiposPerfil perfil);
}
