package com.alura.challenge.foro.domain.repository;

import com.alura.challenge.foro.domain.model.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository  extends JpaRepository<Topico,Long> {

}
