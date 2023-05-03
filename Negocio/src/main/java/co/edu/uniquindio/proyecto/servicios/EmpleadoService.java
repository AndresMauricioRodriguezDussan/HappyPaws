package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.modelo.entidades.*;

import java.util.List;

public interface EmpleadoService {

    Empleado login(String username, String password) throws Exception;

    Empleado actualizarEmpleado(Empleado empleado) throws Exception;

    Empleado obtenerEmpleado(Long idEmpleado) throws Exception;

    Servicio agregarServicio(Servicio servicio) throws Exception;

    void eliminarServicio(Long idServicio) throws Exception;

    Servicio actualizarServicio(Servicio servicio) throws Exception;

    Servicio obtenerServicio(Long idServicio) throws Exception;

    List<Servicio> listarServicios();

    Producto agregarProducto(Producto producto) throws Exception;

    void eliminarProducto(Long idProducto) throws Exception;

    Producto actualizarProducto(Producto producto) throws Exception;

    Producto obtenerProducto(Long idProducto) throws Exception;

    List<Producto> listarProductos();

    void eliminarTareaServicio(Long idServicio,Long idTarea) throws Exception;

    Servicio actualizarTareaServicio(Long idServicio, Tarea tarea) throws Exception;

    List<Cita> obtenerCitasPorTarea(Long idTarea) throws Exception;

    Servicio agregarTareaAServicio(Long idServicio, Long idtareas) throws Exception;

    Tarea agregarTarea(Tarea tarea);

    void eliminarTarea(Long idTarea) throws Exception;

    Tarea actualizarTarea(Tarea tarea) throws Exception;

    Tarea obtenerTarea (Long idTarea) throws Exception;

    List<Tarea> listarTareas();

}
