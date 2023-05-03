package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.entidades.Cliente;
import co.edu.uniquindio.proyecto.modelo.entidades.Mascota;
import co.edu.uniquindio.proyecto.modelo.enums.EspecieEnum;
import co.edu.uniquindio.proyecto.modelo.enums.GeneroEnum;
import co.edu.uniquindio.proyecto.servicios.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Transactional
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest(){
        try {
            Cliente logeado = clienteService.login("mairagarcia","qwerty123");
            Assertions.assertEquals("maria@example.com", logeado.getEmail());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarClienteTest(){
        Map telefonos = new HashMap<String,String>();
        telefonos.put("personal","123");
        telefonos.put("casa","321");
        telefonos.put("otro","213");

        Cliente nuevo = new Cliente("andres", telefonos,"andres@email.com","dussy","andres123","calle falsa 123");

        try {
            Cliente guardado = clienteService.registrarCliente(nuevo);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarClienteTest(){
        try {
            Cliente viejo = clienteService.obtenerCliente(1L);
            viejo.setDireccion("calle no falsa 123");

            Cliente actualizado = clienteService.actualizarCliente(viejo);

            Assertions.assertEquals("calle no falsa 123",actualizado.getDireccion());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarClienteTest(){
        try {
            clienteService.eliminarCliente(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Cliente eliminado = clienteService.obtenerCliente(1L);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerClienteTest(){
        try{
            Cliente buscado = clienteService.obtenerCliente(5L);
            Assertions.assertNotNull(buscado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCitasTest(){
        try {
            List<Cita> buscadas = clienteService.obtenerCitas(1L);
            System.out.println(buscadas);
            Assertions.assertEquals(1,buscadas.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCitasMascotaTest(){
        try {
            List<Cita> buscadas = clienteService.obtenerCitasMascota(3L);
            System.out.println(buscadas);
            Assertions.assertEquals(1,buscadas.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void reservarCitaTest(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agregarMascotaTest(){
        Mascota mascota = Mascota.builder().nombre("Lucas").raza("Schnauzer").edad(13).especie(EspecieEnum.PERRO).genero(GeneroEnum.MACHO).build();
        try {
            Cliente cliente = clienteService.agregarMascota(1L,mascota);
            List<Mascota> mascotas = cliente.getMascotas();
            Assertions.assertEquals(2,mascotas.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarMascotaTest(){
        try {
            clienteService.eliminarMascota(1L,1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            clienteService.obtenerMascota(1L);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void editarMascotaTest(){
        try {
            Mascota mascota = clienteService.obtenerMascota(1L);
            mascota.setNombre("Firu");
            Mascota actualizada = clienteService.actualizarMascota(1L,mascota);

            Assertions.assertEquals("Firu",actualizada.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
