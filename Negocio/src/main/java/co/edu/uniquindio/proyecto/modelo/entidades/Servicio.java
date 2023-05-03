package co.edu.uniquindio.proyecto.modelo.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idServicio;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @PositiveOrZero
    @Positive
    @Column(nullable = false)
    private double precio;

    @Positive
    @Column(nullable = false)
    private int duracion;

    @OneToOne(mappedBy = "servicio")
    @ToString.Exclude
    private Cita cita;

    @ManyToMany
    private List<Tarea> tareas;
    @Builder
    public Servicio(String nombre, String descripcion, double precio, int duracion, List<Tarea> tareas){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion = duracion;
        this.tareas = tareas;
    }
}
