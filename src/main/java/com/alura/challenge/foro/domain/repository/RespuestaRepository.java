package com.alura.challenge.foro.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alura.challenge.foro.domain.model.respuesta.Respuesta;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    @Query("SELECT r FROM replie r WHERE r.topico.id = :topicoId")
    Page<Respuesta> findByTopicoId(@Param("topicoId") Long topicoId, Pageable paginacion);
}
