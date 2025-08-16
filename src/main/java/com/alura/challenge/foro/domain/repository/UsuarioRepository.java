package com.alura.challenge.foro.domain.repository;

import com.alura.challenge.foro.application.dto.usuario.DatosUsuario;
import com.alura.challenge.foro.domain.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Query("SELECT u FROM user u WHERE u.nombre = :name")
    Usuario findByName(@Param("name") String name);
    

}
