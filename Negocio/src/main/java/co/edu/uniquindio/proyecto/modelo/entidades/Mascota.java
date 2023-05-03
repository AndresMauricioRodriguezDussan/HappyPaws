package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enums.EspecieEnum;
import co.edu.uniquindio.proyecto.modelo.enums.GeneroEnum;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Mascota implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idMascota;

    @Column(length = 100, nullable = false)
    private String nombre;

    @PositiveOrZero
    private int edad;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EspecieEnum especie;

    @Column(length = 100)
    private String raza;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    @OneToMany(mappedBy = "mascota")
    @ToString.Exclude
    private List<Cita> citas;

    @ManyToOne
    private Cliente cliente;

    @Builder
    public Mascota(String nombre, int edad, EspecieEnum especie, String raza, GeneroEnum genero){
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.raza = raza;
        this.genero = genero;
    }
}
