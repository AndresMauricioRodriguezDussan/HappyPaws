package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.modelo.entidades.Rol;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.modelo.entidades.UsuarioRol;
import co.edu.uniquindio.proyecto.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class HappyPawsProjectApplication implements CommandLineRunner {

    @Autowired private UsuarioService usuarioService;

    public static void main (String[] args){
        SpringApplication.run(HappyPawsProjectApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Usuario usuario = new Usuario();
        usuario.setNombre("Carlos Vargas");
        usuario.setEmail("carlos@mail.com");
        usuario.setUsername("carlos123");
        usuario.setPassword("123");
        usuario.setTelefonos(Map.of("casa","7456788"));

        Rol rol = new Rol();
        rol.setRolId(1L);
        rol.setNombre("ADMIN");

        Set<UsuarioRol> usuarioRoles = new HashSet<>();
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setUsuario(usuario);
        usuarioRoles.add(usuarioRol);

        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
        System.out.println(usuarioGuardado.getUsername());*/
    }
}

