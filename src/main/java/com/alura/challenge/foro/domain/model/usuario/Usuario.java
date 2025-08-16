package com.alura.challenge.foro.domain.model.usuario;


import com.alura.challenge.foro.domain.model.perfil.Perfil;
import com.alura.challenge.foro.domain.model.perfil.TiposPerfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Usuario  implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(name = "status")
    @Setter
    private boolean stado;

    @NotBlank
    @Column(name = "name")
    private String nombre;

    @Email
    @NotBlank
    @Column(name = "email")
    private  String correo;

    @NotBlank
    @Column(name = "password")
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Perfil perfil;


    public void setPerfil(TiposPerfil tipoPerfil) {
        if (this.perfil == null) {
            this.perfil = new Perfil();
        }
        this.perfil.setPerfil(tipoPerfil);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (perfil != null && perfil.getPerfil() != null) {
            return List.of(new SimpleGrantedAuthority("ROLE_" + perfil.getPerfil().name()));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_" + TiposPerfil.INVITADO.name()));
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
