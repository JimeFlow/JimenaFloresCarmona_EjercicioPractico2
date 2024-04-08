package EjercicioPractico2.domain;

import com.google.type.DateTime;
import jakarta.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="reservas")

public class Reservas implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reservas")
    private Long idReserva;
    
    //private Long idPreservas;  ya no se usa por el @manyToOne
    @NotEmpty
    private int idVuelo;
    private int idCliente;
    private DateTime fechaReserva;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name="id_vuelo")
    @JoinColumn(name="id_cliente")
    Reservas reservas;
    
    public Reservas() {
    }

    public Reservas(Long idReserva, int idVuelo, int idCliente, DateTime fechaReserva, boolean activo) {
        this.idReserva = idReserva;
        this.idVuelo = idVuelo;
        this.idCliente = idCliente;
        this.fechaReserva = fechaReserva;
        this.activo = activo;
    }

    public void setIdVuelo(int idVuelo, Long idPrereservas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Long getIdReserva() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIdCliente(int idCliente, Long idPrereservas1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
