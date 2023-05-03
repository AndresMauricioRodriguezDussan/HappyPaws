package co.edu.uniquindio.proyecto.servicios.impl;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.entidades.Cliente;
import co.edu.uniquindio.proyecto.modelo.entidades.Mascota;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CitaRepository;
import co.edu.uniquindio.proyecto.repositorios.ClienteRepository;
import co.edu.uniquindio.proyecto.repositorios.MascotaRepository;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepository;
import co.edu.uniquindio.proyecto.servicios.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CitaRepository citaRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public Cliente login(String username, String password) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.comprobarAutenticacion(username,password);

        if(usuario != null){
            Optional<Cliente> cliente = clienteRepository.findByUsername(username);
            if (cliente != null){
                return cliente.get();
            }else{
                throw new Exception("Los datos de autenticacion son incorrectos");
            }
        }else {
            throw new Exception("Los datos de autenticacion son erroneos");
        }
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception {
        if (esEmailDisponible(cliente.getEmail())){
            if (esUsernameDisponible(cliente.getUsername())){
                return clienteRepository.save(cliente);
            }else{
                throw new Exception("el username ya se encuentra registrado");
            }
        }else{
            throw new Exception("el email ya se encuentra registrado");
        }
    }

    private boolean esEmailDisponible(String email){
        return usuarioRepository.findByEmail(email).orElse(null)==null;
    }

    private boolean esUsernameDisponible(String username){
        return usuarioRepository.findByUsername(username).orElse(null)== null;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception {
        Optional<Cliente> guardado = clienteRepository.findById(cliente.getIdUsuario());

        if (guardado.isEmpty()){
            throw new Exception("El cliente no existe");
        }else{
            return clienteRepository.save(cliente);
        }
    }

    @Override
    public void eliminarCliente(Long idCliente) throws Exception {
        Optional<Cliente> guardado = clienteRepository.findById(idCliente);

        if (guardado.isEmpty()){
            throw new Exception("El cliente no existe");
        }else{
            clienteRepository.delete(guardado.get());
        }
    }

    @Override
    public Cliente obtenerCliente(Long idCliente) throws Exception {
        Optional<Cliente> buscado = clienteRepository.findById(idCliente);

        if (buscado.isEmpty()){
            throw new Exception("El cliente no existe");
        }else{
            return buscado.get();
        }
    }

    @Override
    public List<Cita> obtenerCitas(Long idCliente) throws Exception {
        Optional<Cliente> buscado = clienteRepository.findById(idCliente);

        if (buscado.isEmpty()){
            throw new Exception("El cliente no existe");
        }else{
            return citaRepository.obtenerCitasMascotasCliente(idCliente);
        }
    }

    @Override
    public List<Cita> obtenerCitasMascota(Long idMascota) throws Exception {
        Optional<Mascota> buscada = mascotaRepository.findById(idMascota);

        if (buscada.isEmpty()){
            throw new Exception("La mascota no existe");
        }else{
            return citaRepository.obtenerCitasMascota(idMascota);
        }
    }

    @Override
    public Cita reservarCita(Cita cita) throws Exception {
        return null;
    }

    @Override
    public Cliente agregarMascota(Long idUsuario,Mascota mascota) throws Exception {
        Optional<Cliente> buscado =  clienteRepository.findById(idUsuario);
        if (buscado.isEmpty()){
            throw new Exception("El cliente no existe");
        }else{
            Cliente cliente = buscado.get();
            List<Mascota> mascotas = cliente.getMascotas();
            mascota.setCliente(cliente);
            mascotas.add(mascota);
            cliente.setMascotas(mascotas);

            return clienteRepository.save(cliente);
        }
    }

    @Override
    public void eliminarMascota(Long idUsuario, Long idMascota) throws Exception {
        Optional<Cliente> clienteBuscado =  clienteRepository.findById(idUsuario);
        if (clienteBuscado.isEmpty()){
            throw new Exception("El cliente no existe");
        }else{
            Optional<Mascota> mascotaBuscada = mascotaRepository.findById(idMascota);

            if (mascotaBuscada.isEmpty()){
                throw new Exception("La mascota no existe");
            }else{
                Cliente cliente = clienteBuscado.get();
                Mascota mascota = mascotaBuscada.get();
                List<Mascota> mascotas =cliente.getMascotas();

                if(mascotas.contains(mascota)){
                    mascotas.remove(mascota);
                    cliente.setMascotas(mascotas);

                    clienteRepository.save(cliente);
                    mascotaRepository.delete(mascota);
                }else{
                    throw new Exception("La mascota:" + idMascota +" no pertenece al cliente:"+ idUsuario);
                }
            }
        }
    }

    @Override
    public Mascota actualizarMascota(Long idUsuario, Mascota mascota) throws Exception {
        Optional<Cliente> clienteBuscado =  clienteRepository.findById(idUsuario);
        if (clienteBuscado.isEmpty()){
            throw new Exception("El cliente no existe");
        }else{
            return mascotaRepository.save(mascota);
        }
    }

    @Override
    public Mascota obtenerMascota(Long idMascota) throws Exception {
        Optional<Mascota> mascotaBuscada = mascotaRepository.findById(idMascota);

        if (mascotaBuscada.isEmpty()){
            throw new Exception("La mascota no existe");
        }else{
            return mascotaBuscada.get();
        }
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }
}
