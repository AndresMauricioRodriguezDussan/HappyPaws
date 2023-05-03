package co.edu.uniquindio.proyecto.modelo.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class AgendaEmpleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private Long idAgenda;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    private Empleado empleado;

    @ToString.Exclude
    @OneToMany(mappedBy = "agendaEmpleado")
    private List<Cita> citas;

}
