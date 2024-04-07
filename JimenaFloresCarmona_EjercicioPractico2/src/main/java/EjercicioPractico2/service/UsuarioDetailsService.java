package EjercicioPractico2.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioDetailsService {

    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException;
    
}
