package com.alura.challenge.foro.application.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alura.challenge.foro.application.dto.usuario.CrearUsuario;
import com.alura.challenge.foro.application.dto.usuario.DetallesUsuario;
import com.alura.challenge.foro.application.service.perfil.PerfilService;
import com.alura.challenge.foro.domain.repository.UsuarioRepository;



@Service
public class UsuarioService {

    //reposotury
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Encriptado de la contraseña
    @Autowired
    private PasswordEncoder passwordEncoder;

    //service
    @Autowired
    private PerfilService perfilService;

    //clase auxiliar para convercion de datos
    @Autowired
    private ConvertirDatosUsuario convertirDatos;

    //Crear usuario
    @Transactional
    public DetallesUsuario CrearUsuario(CrearUsuario crearUsuario){
        try {
            var usuario =convertirDatos.crearUsuario(crearUsuario);
            usuarioRepository.save(usuario);

            return convertirDatos.crearDetallesUsuario(usuario);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Cambiar atributo activo a false
    @Transactional
    public  void EliminarUsuario(Long id ){
        var usuario=usuarioRepository.findById(id);
        usuario.get().setActivo(false);
    }

    //Devuelve todos los usuarios en paginas
    public Page<DetallesUsuario> listaUsuarios(Pageable paginacion){
        return usuarioRepository.findAllByActivoTrue(paginacion)
                .map(usuario -> convertirDatos.crearDetallesUsuario(usuario));
    }
}
