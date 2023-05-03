package co.edu.uniquindio.proyecto.modelo.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idProducto;

    @Column(length = 100,nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @PositiveOrZero
    @Column(nullable = false)
    private double precio;

    @PositiveOrZero
    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private String imagen;

    @Builder
    public Producto(String nombre, String descripcion, double precio, int stock, String imagen){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;
    }

}
