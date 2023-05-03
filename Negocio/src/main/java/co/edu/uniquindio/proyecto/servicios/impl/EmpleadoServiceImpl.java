package co.edu.uniquindio.proyecto.servicios.impl;

import co.edu.uniquindio.proyecto.modelo.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import co.edu.uniquindio.proyecto.servicios.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    ServicioRepository servicioRepository;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    TareaRepository tareaRepository;

    @Override
    public Empleado login(String username, String password) throws Exception {
        Optional<Usuario>  usuario = usuarioRepository.comprobarAutenticacion(username,password);

        if(usuario != null){
            Optional<Empleado> empleado = empleadoRepository.findByUsername(username);
            if (empleado != null){
                return empleado.get();
            }else{
                throw new Exception("Los datos de autenticacion son incorrectos");
            }
        }else {
            throw new Exception("Los datos de autenticacion son erroneos");
        }
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) throws Exception {
        Optional<Empleado> guardado = empleadoRepository.findById(empleado.getIdUsuario());

        if (guardado.isEmpty()){
            throw new Exception("El empleado no existe");
        }else{
            return empleadoRepository.save(empleado);
        }
    }

    @Override
    public Empleado obtenerEmpleado(Long idEmpleado) throws Exception {
        Optional<Empleado> buscado = empleadoRepository.findById(idEmpleado);

        if (buscado.isEmpty()){
            throw new Exception("El empleado no existe");
        }else{
            return buscado.get();
        }
    }

    @Override
    public Servicio agregarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public void eliminarServicio(Long idServicio) throws Exception {
        Optional<Servicio> guardado = servicioRepository.findById(idServicio);

        if(guardado.isEmpty()){
            throw new Exception("El servicio no existe");
        }else{
            servicioRepository.delete(guardado.get());
        }
    }

    @Override
    public Servicio actualizarServicio(Servicio servicio) throws Exception {
        Optional<Servicio> guardado = servicioRepository.findById(servicio.getIdServicio());

        if(guardado.isEmpty()){
            throw new Exception("El servicio no existe");
        }else{
            return servicioRepository.save(servicio);
        }
    }

    @Override
    public Servicio obtenerServicio(Long idServicio) throws Exception {
        Optional<Servicio> guardado = servicioRepository.findById(idServicio);

        if(guardado.isEmpty()){
            throw new Exception("El servicio no existe");
        }else{
            return guardado.get();
        }
    }

    @Override
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public Producto agregarProducto(Producto producto) throws Exception {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long idProducto) throws Exception {
        Optional<Producto> guardado = productoRepository.findById(idProducto);

        if (guardado.isEmpty()){
            throw new Exception("El producto no existe");
        }else{
            productoRepository.delete(guardado.get());
        }
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws Exception {
        Optional<Producto> guardado = productoRepository.findById(producto.getIdProducto());

        if (guardado.isEmpty()){
            throw new Exception("El producto no existe");
        }else{
            return productoRepository.save(producto);
        }
    }

    @Override
    public Producto obtenerProducto(Long idProducto) throws Exception {
        Optional<Producto> guardado = productoRepository.findById(idProducto);

        if (guardado.isEmpty()){
            throw new Exception("El producto no existe");
        }else{
            return guardado.get();
        }
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void eliminarTareaServicio(Long idServicio, Long idTarea) throws Exception {
        Optional<Servicio> ServicioBuscado = servicioRepository.findById(idServicio);
        Optional<Tarea> tareaBuscada = tareaRepository.findById(idTarea);
        if (validarServicio(idServicio)){
            if (validarTarea(idTarea)){
                Servicio servicio = ServicioBuscado.get();
                List<Tarea> tareas = servicio.getTareas();

                if (tareas.contains(tareaBuscada.get())){
                    tareas.remove(tareaBuscada.get());
                    servicio.setTareas(tareas);

                    servicioRepository.save(servicio);
                }else {
                    throw new Exception("El servicio no tiene registrada esta tarea");
                }

            }else{
                throw new Exception("La tarea no existe");
            }
        }else{
            throw new Exception("El servicio no existe");
        }
    }

    @Override
    public Servicio actualizarTareaServicio(Long idServicio, Tarea tarea) throws Exception {
        Optional<Servicio> servicioBuscado = servicioRepository.findById(idServicio);
        Optional<Tarea> tareaBuscada = tareaRepository.findById(tarea.getIdTarea());

        if (servicioBuscado.isEmpty()){
            throw new Exception("El servicio no existe");
        }else{
            if (tareaBuscada.isEmpty()){
                throw new Exception("La tarea no existe");
            }else{
                Servicio servicio = servicioBuscado.get();

                Tarea actualizada = tareaRepository.save(tarea);
                List<Tarea> tareas = servicio.getTareas();

                tareas.add(actualizada);
                servicio.setTareas(tareas);
                return servicioRepository.save(servicio);
            }
        }
    }

    @Override
    public List<Cita> obtenerCitasPorTarea(Long idTarea) throws Exception {
        if (validarServicio(idTarea)){
            List<Cita> tareasServicio = tareaRepository.obtenerCitasPorTarea(idTarea);
            return tareasServicio;
        }else{
            throw new Exception("La tarea no existe");
        }
    }

    @Override
    public Servicio agregarTareaAServicio(Long idServicio, Long idTarea) throws Exception {
        Optional<Servicio> servicioBuscado = servicioRepository.findById(idServicio);
        Optional<Tarea> tareaBuscada = tareaRepository.findById(idTarea);

        if (servicioBuscado.isEmpty()){
            throw new Exception("El servicio no existe");
        }else{
            if (tareaBuscada.isEmpty()){
                throw new Exception("La tarea no existe");
            }else{
                Servicio servicio = servicioBuscado.get();
                Tarea tarea = tareaBuscada.get();
                List<Tarea> tareas = servicio.getTareas();
                tareas.add(tarea);
                servicio.setTareas(tareas);

                return servicioRepository.save(servicio);
            }
        }
    }

    @Override
    public Tarea agregarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public void eliminarTarea(Long idTarea) throws Exception {
        Optional<Tarea> buscada = tareaRepository.findById(idTarea);

        if (buscada.isEmpty()){
            throw new Exception("La tarea no existe");
        }else{
            tareaRepository.delete(buscada.get());
        }
    }

    @Override
    public Tarea actualizarTarea(Tarea tarea) throws Exception {
        Optional<Tarea> buscada = tareaRepository.findById(tarea.getIdTarea());

        if(buscada.isEmpty()){
            throw new Exception("La tarea no existe");
        }else{
            return tareaRepository.save(tarea);
        }
    }

    @Override
    public Tarea obtenerTarea(Long idTarea) throws Exception {
        Optional<Tarea> buscada = tareaRepository.findById(idTarea);

        if (buscada.isEmpty()){
            throw new Exception("La tarea no existe");
        }else{
            return buscada.get();
        }
    }

    @Override
    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    private boolean validarTarea(Long idTarea) {
        Optional<Tarea> buscada = tareaRepository.findById(idTarea);
        boolean estado = true;
        if (buscada.isEmpty()) {
            estado = false;
        }
        return  estado;
    }

    private boolean validarServicio(Long idServicio){
        Optional<Servicio> buscado = servicioRepository.findById(idServicio);
        boolean estado = true;
        if (buscado.isEmpty()){
            estado = false;
        }
        return estado;
    }
}
