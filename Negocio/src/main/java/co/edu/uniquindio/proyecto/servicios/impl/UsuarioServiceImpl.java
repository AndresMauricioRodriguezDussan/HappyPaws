package co.edu.uniquindio.proyecto.servicios.impl;

import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.modelo.entidades.UsuarioRol;
import co.edu.uniquindio.proyecto.repositorios.RolRepository;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepository;
import co.edu.uniquindio.proyecto.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;
    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Optional<Usuario> usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        Usuario usuarioAux = new Usuario();
        if(usuarioLocal.isPresent()){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta registrado en el sistema");
        }else{
            for(UsuarioRol usuarioRol : usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioAux = usuarioRepository.save(usuario);
        }
        return usuarioAux;
    }

    @Override
    public Usuario obtenerUsuario(String username) {

        return usuarioRepository.findByUsername(username).get();
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
