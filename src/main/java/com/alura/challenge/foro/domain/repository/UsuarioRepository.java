package com.alura.challenge.foro.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alura.challenge.foro.domain.model.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Query("SELECT u from user u where u.correo=:email")
    Usuario findByEmail(@Param("email") String email);


    Page<Usuario> findAllByActivoTrue(Pageable paginacion);
}
