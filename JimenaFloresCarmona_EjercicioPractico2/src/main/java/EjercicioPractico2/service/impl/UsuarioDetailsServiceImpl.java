package EjercicioPractico2.service.impl;

import EjercicioPractico2.service.UsuarioDetailsService;
import EjercicioPractico2.dao.UsuarioDao;
import EjercicioPractico2.domain.Usuario;
import EjercicioPractico2.domain.Rol;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService{
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException{
        //Buscar el usuario por el username en la tabla
        Usuario usuario = usuarioDao.findByUsername(nombreUsuario);
        //Si no existe el usuaio lanza una excepcion
        if (usuario == null) {
            throw new UsernameNotFoundException(nombreUsuario);
    }
    session.removeAttribute("usuarioRol");
    session.setAttribute("usuarioRol", usuario.getIdRolUsuario());
    //Si esta aca es porque existe el usuario... sacamos los roles que tiene
    var roles = new ArrayList<GrantedAuthority>();
    for (Rol rol : usuario.getRoles()){  //Se sacan los roles
        roles.add(new SimpleGrantedAuthority(rol.getNombre()));
    }
    //Se devuelve User clase de userDetails
    return new User(usuario.getNombreUsuario(), usuario.getContrasena(), roles);
    }
    
}