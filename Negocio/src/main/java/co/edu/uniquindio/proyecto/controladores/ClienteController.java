package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.modelo.entidades.Cliente;
import co.edu.uniquindio.proyecto.servicios.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200/")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteService.obtenerClientes();
    }
}
