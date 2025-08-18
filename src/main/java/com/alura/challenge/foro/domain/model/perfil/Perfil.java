package com.alura.challenge.foro.domain.model.perfil;

import com.alura.challenge.foro.domain.model.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Table(name = "profiles")
@Entity(name = "profile")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @Column(name = "profile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotNull
    @Column(name = "profile")
    @Enumerated(EnumType.STRING)
    private TiposPerfil perfil;

    public Perfil(TiposPerfil perfil) {
        this.perfil = perfil;
    }

}


