package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.modelo.entidades.*;
import co.edu.uniquindio.proyecto.modelo.enums.CargoEnum;
import co.edu.uniquindio.proyecto.servicios.EmpleadoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class EmpleadoServiceTest {

    @Autowired
    private EmpleadoService empleadoService;

    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest(){
        try{
            Empleado logeado = empleadoService.login("luisap","contrasena");
            Assertions.assertEquals(8L,logeado.getIdUsuario());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEmpleadoTest(){
        try {
            Empleado viejo = empleadoService.obtenerEmpleado(7L);
            viejo.setLicencia("465654654");

            Empleado actualizado = empleadoService.actualizarEmpleado(viejo);

            Assertions.assertEquals("465654654",viejo.getLicencia());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerEmpleadoTest(){
        try {
            {
                Empleado buscado = empleadoService.obtenerEmpleado(6L);
                Assertions.assertEquals(CargoEnum.VETERINARIO,buscado.getCargo());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agregarServicioTest(){
        Servicio nuevo = Servicio.builder().descripcion("Cortado de uñas y limpieza de orejas").duracion(40).nombre("limpieza").precio(10).build();

        Servicio guardado = null;
        try {
            guardado = empleadoService.agregarServicio(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarServicioTest(){
        try {
            empleadoService.eliminarServicio(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            Servicio eliminado = empleadoService.obtenerServicio(1L);
        } catch (Exception e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarServicioTest(){
        try{
            Servicio guardado =  empleadoService.obtenerServicio(1L);
            guardado.setPrecio(9.99);

            Servicio actualizado = empleadoService.actualizarServicio(guardado);

            Assertions.assertEquals(9.99,actualizado.getPrecio());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerServicioTest(){
        try{
            Servicio buscado = empleadoService.obtenerServicio(1L);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarServiciosTest(){
        List<Servicio> servicios = empleadoService.listarServicios();

        Assertions.assertEquals(5,servicios.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agregarProductoTest(){
        Producto nuevo = Producto.builder().descripcion("galletas en forma de hueso con nutrientes").imagen("premio.jpg").nombre("premios para perro").precio(2).stock(100).build();

        try {
            Producto guardado = empleadoService.agregarProducto(nuevo);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarProductoTest(){
        try {
            empleadoService.eliminarProducto(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            Producto eliminado = empleadoService.obtenerProducto(1L);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProductoTest(){
        try {
            Producto guardado = empleadoService.obtenerProducto(1L);
            guardado.setStock(50);

            Producto actualizado = empleadoService.actualizarProducto(guardado);

            Assertions.assertEquals(50,actualizado.getStock());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductoTest(){
        try{
            Producto buscado = empleadoService.obtenerProducto(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosTest(){
        List<Producto> productos = empleadoService.listarProductos();

        Assertions.assertEquals(5,productos.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTareaServicioTest(){
        try {
            empleadoService.eliminarTareaServicio(1L,1L);
            List<Tarea> tareasServicio = empleadoService.obtenerServicio(1L).getTareas();
            Assertions.assertEquals(1,tareasServicio.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarTareaServicioTest(){

        Tarea nueva = null;
        try {
            nueva = empleadoService.obtenerTarea(2L);
            nueva.setDescripcion("Vacunacion de perros pequeños");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Servicio servicio = empleadoService.actualizarTareaServicio(1L,nueva);
            List<Tarea> tareas = servicio.getTareas();

            System.out.println(tareas);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCitasPorTareaTest(){
        try {
            List<Cita> citas = empleadoService.obtenerCitasPorTarea(2L);
            Assertions.assertEquals(2,citas.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agregarTareasAServicioTest(){
        try {
            Servicio servicio = empleadoService.agregarTareaAServicio(1L,3L);
            List<Tarea> encontradas = servicio.getTareas();

            Assertions.assertEquals(3,encontradas.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agregarTareaTest(){
        Tarea nueva = Tarea.builder().nombre("sumininistracion de medicamento").descripcion("se le suministro trembolona al paciente").build();

        Tarea guardada = empleadoService.agregarTarea(nueva);

        Assertions.assertNotNull(guardada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTareaTest(){
        try {
            empleadoService.eliminarTarea(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Tarea eliminado = empleadoService.obtenerTarea(1L);
        } catch (Exception e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarTareaTest(){
        try {
            Tarea guardada = empleadoService.obtenerTarea(1L);
            guardada.setNombre("Limpieza de dientes, nariz y orejas");

            Tarea actualizado = empleadoService.actualizarTarea(guardada);

            Assertions.assertEquals("Limpieza de dientes, nariz y orejas",actualizado.getNombre());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerTareaTest(){
        try {
            Tarea buscado = empleadoService.obtenerTarea(1L);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTareasTest(){
        List<Tarea> tareas = empleadoService.listarTareas();

        Assertions.assertEquals(5,tareas.size());
    }
}
