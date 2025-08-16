package com.alura.challenge.foro.domain.model.respuesta;

import com.alura.challenge.foro.domain.model.topico.Topico;
import com.alura.challenge.foro.domain.model.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "replie")
@Table(name = "replies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "replies_id")
    private Long id;

    @NotBlank
    @Column(name = "message")
    private String mensaje;
    @ManyToOne(targetEntity = Topico.class)

    @JoinColumn(name ="topic_id")
    private Topico topico;

    @Column(name = "creation_date",insertable = false)
    private LocalDateTime fechaCreacion;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "author")
    private Usuario autor;


}
