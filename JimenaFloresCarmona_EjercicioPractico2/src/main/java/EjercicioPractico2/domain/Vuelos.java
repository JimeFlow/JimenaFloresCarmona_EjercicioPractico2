package EjercicioPractico2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
//import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "vuelos")

public class Vuelos implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vuelo")
    private Long idVuelo;
    private String numeroVuelo;
    private String destino;
    private String lugarSalida;
    private Time horaSalida;
    private Date fechaSalida;
    private Date fechaLlegada;
    private String modeloAvion;
    private String rutaVuelo;
    private boolean activo;

    //@OneToMany
    //@JoinColumn(name = "id_vuelo", updatable = false)
    //List<Prereservas> prereservas;
    
    //@OneToMany
    //@JoinColumn(name = "id_vuelo", updatable = false)
    //List<Reservas> reservas;
    
    public Vuelos() {
    }

    public Vuelos(Long idVuelo, String numeroVuelo, String destino, String modeloAvion, String rutaVuelo, boolean activo) {
        this.idVuelo = idVuelo;
        this.numeroVuelo = numeroVuelo;
        this.destino = destino;
        this.modeloAvion = modeloAvion;
        this.rutaVuelo = rutaVuelo;
        this.activo = activo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setRutaVuelo(String rutaVuelo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}