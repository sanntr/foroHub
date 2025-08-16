package com.alura.challenge.foro.domain.repository;

import com.alura.challenge.foro.domain.model.respuesta.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
}
