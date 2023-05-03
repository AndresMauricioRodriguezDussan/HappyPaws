package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Long> {
    @Query("SELECT c FROM Cita c " +
            "JOIN c.mascota m " +
            "JOIN m.cliente cli " +
            "WHERE cli.idUsuario = :idCliente")
    List<Cita> obtenerCitasMascotasCliente(Long idCliente);
    @Query("SELECT c FROM Cita c WHERE c.mascota.idMascota = :idMascota")
    List<Cita> obtenerCitasMascota(Long idMascota);
}
