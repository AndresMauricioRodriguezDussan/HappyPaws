package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Mascota;
import co.edu.uniquindio.proyecto.modelo.entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long> {

    /*
     * Esto es para la primera historia de usuario
     */
    @Query("SELECT s FROM Servicio s JOIN s.cita c JOIN c.mascota m WHERE m.idMascota = :idMascota")
    List<Servicio> obtenerServiciosMascota(Long idMascota);
}
