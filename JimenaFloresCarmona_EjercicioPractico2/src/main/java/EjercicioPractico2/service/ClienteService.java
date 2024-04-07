package EjercicioPractico2.service;

import EjercicioPractico2.domain.Cliente;
import java.util.List;

public interface ClienteService {
    
    // Se obtiene un listado de clientes en un List
    public List<Cliente> getClientes();
    
    // Se obtiene un Cliente, a partir del id de un cliente
    public Cliente getCliente(Cliente cliente);
    
    // Se obtiene un Cliente, a partir del nombre de un cliente
    public Cliente getClientePorNombre(String nombre);
    
    // Se obtiene un Cliente, a partir del nombre y apellido de un cliente
    public Cliente getClientePorNombreYApellido(String nombre, String apellidos);
    
    // Se obtiene un Cliente, a partir del nombre y id de un cliente
    public Cliente getClientePorNombreYId(String nombre, int idCliente);
    
    // Se obtiene un Cliente, a partir del username de un cliente
    public Cliente getClientePorUsername(String nombreUsuario);

    // Se obtiene un Cliente, a partir del username y el password de un cliente
    public Cliente getClientePorUsernameYPassword(String nombreUsuario, String contrasena);
    
    // Se obtiene un Cliente, a partir del username y el password de un cliente
    public Cliente getClientePorUsernameOCorreo(String nombreUsuario, String correo);
    
    // Se valida si existe un Cliente considerando el username
    public boolean existeClientePorUsernameOCorreo(String nombreUsuario, String correo);
    
    // Se inserta un nuevo cliente si el id del cliente esta vacío
    // Se actualiza un cliente si el id del cliente NO esta vacío
    public void save(Cliente cliente, int idRolCliente);
    public void save(Cliente cliente, boolean idRolClient);
    
    // Se elimina el cliente que tiene el id pasado por parámetro
    public void delete(Cliente cliente);
    
}
