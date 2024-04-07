package EjercicioPractico2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
//import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotEmpty
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String NombreUsuario;
    private String contrasena;
    private int idRolUsuario;
    private boolean activo;
    
    //@OneToMany
    //@JoinColumn(name = "id_usuario")
    //private List<Rol> roles;
    
}