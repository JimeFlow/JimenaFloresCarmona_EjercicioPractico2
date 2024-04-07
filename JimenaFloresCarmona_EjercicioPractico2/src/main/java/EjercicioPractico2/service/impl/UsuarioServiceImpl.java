package EjercicioPractico2.service.impl;

//import EjercicioPractico2.dao.RolDao;
import EjercicioPractico2.dao.UsuarioDao;
//import EjercicioPractico2.domain.Rol;
import EjercicioPractico2.domain.Usuario;
import EjercicioPractico2.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    //private RolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String nombreUsuario) {
        return usuarioDao.findByUsername(nombreUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYPassword(String nombreUsuario, String contrasena) {
        return usuarioDao.findByUsernameAndPassword(nombreUsuario, contrasena);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameOCorreo(String nombreUsuario, String correo) {
        return usuarioDao.findByUsernameOrCorreo(nombreUsuario, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String nombreUsuario, String correo) {
        return usuarioDao.existsByUsernameOrCorreo(nombreUsuario, correo);
    }

    @Override
    @Transactional
    public void save(Usuario usuario, boolean idRolUser) {
        usuario = usuarioDao.save(usuario);
        if (idRolUser) {  //Si se está creando el usuario, se crea el rol por defecto "USER"
            //Rol rol = new Rol();
            //rol.setNombre("ROLE_USER");
            
            //rol.setIdUsuario(usuario.getIdUsuario().toString()); //Conversion Long to String
            //rolDao.save(rol);
        }
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

}
