
package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enums.CargoEnum;
import lombok.*;

import javax.persistence.*;
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
@DiscriminatorValue("Empleado")
public class Empleado extends Usuario{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CargoEnum cargo;

    @Column(length = 10)
    private String licencia;

    @OneToMany(mappedBy = "empleado")
    @ToString.Exclude
    private List<AgendaEmpleado> agendasEmpleado;

    public Empleado (String nombre, Map<String,String> telefonos, @Email String email, String usuario, String password, CargoEnum cargo, String licencia ){
        super(nombre,telefonos, email, usuario, password);
        this.cargo = cargo;
        this.licencia  = licencia;
    }

}
