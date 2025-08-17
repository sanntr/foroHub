package com.alura.challenge.foro.domain.repository;

import com.alura.challenge.foro.domain.model.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CursoReopsitory  extends JpaRepository<Curso,Long> {
    @Query("""
            select c from course c where c.id= :id
            """)
    Curso FindById(@Param("id") Long id);
}
