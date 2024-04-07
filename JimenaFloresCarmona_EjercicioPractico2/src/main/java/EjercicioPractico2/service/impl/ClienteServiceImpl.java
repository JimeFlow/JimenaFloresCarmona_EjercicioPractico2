package EjercicioPractico2.service.impl;

import EjercicioPractico2.dao.RolDao;
import EjercicioPractico2.dao.ClienteDao;
import EjercicioPractico2.domain.Rol;
import EjercicioPractico2.domain.Cliente;
import EjercicioPractico2.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getClientePorNombre(String nombre) {
        return clienteDao.findByName(nombre);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Cliente getClientePorNombreYApellido(String nombre, String apellidos) {
        return clienteDao.findByNameAndLastname(nombre, apellidos);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Cliente getClientePorNombreYId(String nombre, int idCliente) {
        return clienteDao.findByNameAndId(nombre, idCliente);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Cliente getClientePorUsername(String nombreUsuario) {
        return clienteDao.findByUsername(nombreUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getClientePorUsernameYPassword(String nombreUsuario, String contrasena) {
        return clienteDao.findByUsernameAndPassword(nombreUsuario, contrasena);
    }
    
    @Transactional(readOnly = true)
    public Cliente getUsuarioPorUsernameOCorreo(String nombreUsuario, String correo) {
        return clienteDao.findByUsernameOrCorreo(nombreUsuario, correo);
    }
    
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String nombreUsuario, String correo) {
        return clienteDao.existsByUsernameOrCorreo(nombreUsuario, correo);
    }

    @Override
    @Transactional
    public void save(Cliente cliente, boolean idRolClient) {
        cliente = clienteDao.save(cliente);
        if (idRolClient) {  //Si se está agregando el cliente, se crea el rol por defecto "USER"
            Rol rol = new Rol();
            rol.setNombre("ROLE_CLIENT");
            
            rol.setIdCliente(cliente.getIdCliente().toString()); //Conversion Long to String
            rolDao.save(rol);
        }
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

}
