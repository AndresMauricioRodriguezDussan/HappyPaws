package co.edu.uniquindio.proyecto.modelo.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private Long idCita;

    @Column(nullable = false)
    private LocalDateTime fechaHoraInicio;

    @Column(nullable = false)
    private LocalDateTime fechaHoraFin;

    @OneToOne
    private Servicio servicio;

    @ManyToOne
    private Mascota mascota;

    @ManyToOne
    private AgendaEmpleado agendaEmpleado;

    @Builder
    public Cita(Servicio servicio,Mascota mascota, AgendaEmpleado agendaEmpleado){
        this.servicio = servicio;
        this.mascota = mascota;
        this.agendaEmpleado = agendaEmpleado;
    }


}
