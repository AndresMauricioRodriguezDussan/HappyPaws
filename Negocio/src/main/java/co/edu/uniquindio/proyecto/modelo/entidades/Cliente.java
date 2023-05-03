package co.edu.uniquindio.proyecto.modelo.entidades;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@DiscriminatorValue("Cliente")
public class Cliente extends Usuario{

    private String direccion;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Mascota> mascotas;


    public Cliente(String nombre,Map<String,String> telefonos, @Email String email, String username, String password, String direccion) {
        super(nombre,telefonos, email, username, password);
        this.direccion = direccion;
    }
}
