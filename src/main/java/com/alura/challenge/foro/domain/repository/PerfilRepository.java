package com.alura.challenge.foro.domain.repository;

import com.alura.challenge.foro.domain.model.perfil.Perfil;
import com.alura.challenge.foro.domain.model.perfil.TiposPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Optional<Perfil> findByPerfil(TiposPerfil perfil);

    Optional<Perfil> existsByPerfil(TiposPerfil tiposPerfil);
}
