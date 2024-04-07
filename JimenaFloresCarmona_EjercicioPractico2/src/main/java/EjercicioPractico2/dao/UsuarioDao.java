package EjercicioPractico2.dao;

import EjercicioPractico2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository <Usuario, Long> {
    
    Usuario findByUsername(String nombreUsuario);
    
    Usuario findByUsernameAndPassword(String nombreUsuario, String contrasena);

    Usuario findByUsernameOrCorreo(String nombreUsuario, String correo);

    boolean existsByUsernameOrCorreo(String nombreUsuario, String correo);
    
}
