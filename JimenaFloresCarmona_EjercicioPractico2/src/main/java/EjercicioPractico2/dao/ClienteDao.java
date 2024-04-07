package EjercicioPractico2.dao;

import EjercicioPractico2.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository <Cliente, Long> {
    
    Cliente findByName(String nombre);
    
    Cliente findByNameAndLastname(String nombre, String apellidos);
    
    Cliente findByNameAndId(String nombre, int idCliente);
    
    Cliente findByUsername(String nombreUsuario);
    
    Cliente findByUsernameAndPassword(String nombreUsuario, String contrasena);

    Cliente findByUsernameOrCorreo(String nombreUsuario, String correo);

    boolean existsByUsernameOrCorreo(String nombreUsuario, String correo);
    
}
