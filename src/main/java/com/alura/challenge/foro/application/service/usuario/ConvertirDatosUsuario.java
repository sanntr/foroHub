package com.alura.challenge.foro.application.service.usuario;

import com.alura.challenge.foro.application.dto.usuario.CrearUsuario;
import com.alura.challenge.foro.application.dto.usuario.DetallesUsuario;
import com.alura.challenge.foro.application.service.perfil.PerfilService;
import com.alura.challenge.foro.domain.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ConvertirDatosUsuario {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PerfilService perfilService;

    public Usuario crearUsuario(CrearUsuario crearUsuario){
        return new Usuario(
                crearUsuario.nombre(),
                crearUsuario.email(),
                passwordEncoder.encode(crearUsuario.contrasena()),
                perfilService.crearPerfil(crearUsuario.perfil())
        );
    }

    public DetallesUsuario crearDetallesUsuario(Usuario usuario){
        return new DetallesUsuario(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getPerfil().getPerfil()
        );
    }
}
