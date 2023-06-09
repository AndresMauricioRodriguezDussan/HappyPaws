package co.edu.uniquindio.proyecto.modelo.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idUsuario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ElementCollection
    private Map<String,String> telefonos;

    @Email
    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(nullable = false,length = 100,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_usuario")
    private Cliente cliente;
    @Builder
    public Usuario(String nombre, Map<String,String> telefonos, String email, String username, String password){
        this.nombre =  nombre;
        this.telefonos = telefonos;
        this.email = email;
        this.username = username;
        this.password = password;
        this.enabled = false;
    }
}
