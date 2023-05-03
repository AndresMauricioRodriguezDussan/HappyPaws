package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.entidades.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    @Query("SELECT c FROM Cita c  JOIN c.servicio s JOIN s.tareas t  WHERE t.idTarea = :idTarea")
    List<Cita> obtenerCitasPorTarea(Long idTarea);
}
