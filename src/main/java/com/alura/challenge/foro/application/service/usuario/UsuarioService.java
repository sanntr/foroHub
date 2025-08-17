package com.alura.challenge.foro.application.service.usuario;

import com.alura.challenge.foro.application.dto.usuario.CrearUsuario;
import com.alura.challenge.foro.application.dto.usuario.DetallesUsuario;
import com.alura.challenge.foro.domain.model.perfil.Perfil;
import com.alura.challenge.foro.domain.model.usuario.Usuario;
import com.alura.challenge.foro.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public DetallesUsuario CrearUsuario(CrearUsuario crearUsuario){
        try {
            var usuario =new Usuario(
                    crearUsuario.nombre(),
                    crearUsuario.email(),
                    crearUsuario.contrasena(),
                    new Perfil(crearUsuario.perfil()
                    )
            );
            usuarioRepository.save(usuario);

            return new DetallesUsuario(
                    usuario.getId(),
                    usuario.getNombre(),
                    usuario.getCorreo(),
                    usuario.getPerfil().getPerfil().toString()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
