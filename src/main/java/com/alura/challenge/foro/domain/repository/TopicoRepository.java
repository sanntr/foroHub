package com.alura.challenge.foro.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.alura.challenge.foro.domain.model.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface TopicoRepository  extends JpaRepository<Topico,Long> {

    Optional<Topico> findById(Long id);

    @Query("""
            select t from topic t where replace (lower (t.titulo),' ', '') =REPLACE(LOWER(:titulo), ' ', '')
            """)
    Optional<Topico> topicoExiste(@Param("titulo")String titulo);

    Page<Topico> findAllByActivoTrue(Pageable pageable);
}
