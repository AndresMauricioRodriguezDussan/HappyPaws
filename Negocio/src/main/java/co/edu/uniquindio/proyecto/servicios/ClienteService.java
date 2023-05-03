package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.entidades.Cliente;
import co.edu.uniquindio.proyecto.modelo.entidades.Mascota;

import java.util.List;

public interface ClienteService {

    Cliente login(String username, String password) throws Exception;

    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    void eliminarCliente(Long idCliente) throws Exception;

    Cliente obtenerCliente(Long idCliente) throws Exception;

    List<Cita> obtenerCitas(Long idCliente) throws Exception;

    List<Cita> obtenerCitasMascota(Long idMascota) throws Exception;

    Cita reservarCita(Cita cita) throws  Exception;

    Cliente agregarMascota(Long idUsuario, Mascota mascota) throws Exception;

    void eliminarMascota(Long idUsuario,Long idMascota) throws Exception;

    Mascota actualizarMascota(Long idUsuario,Mascota mascota) throws Exception;

    Mascota obtenerMascota(Long idMascota) throws Exception;

    List<Cliente> obtenerClientes();
}
