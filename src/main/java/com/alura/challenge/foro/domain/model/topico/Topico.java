package com.alura.challenge.foro.domain.model.topico;

import com.alura.challenge.foro.domain.model.curso.Curso;
import com.alura.challenge.foro.domain.model.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "topic")
@Table(name = "topics")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@ToString
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long id;

    @Setter
    @NotNull
    @Column(name = "active")
    private boolean activo;
    @NotBlank
    @Column(name = "topic_title")
    private  String titulo;

    @Column(name = "message")
    private String mensaje;

    @Column(name = "creation_date",insertable = false)
    private LocalDateTime fechaCreacion;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "author")
    private Usuario autor;

    @ManyToOne(targetEntity = Curso.class)
    @JoinColumn(name = "course_id")
    private  Curso curso;

    public Topico(String titulo, String mensaje, Usuario autor, Curso curso ) {
        this.titulo=titulo;
        this.mensaje=mensaje;
        this.autor=autor;
        this.curso=curso;
        this.activo=true;
    }


}
