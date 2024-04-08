package EjercicioPractico2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="prereservas")

public class Prereservas implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_prereservas")
    private Long idPrereserva;
    
    //private Long idPreservas;  ya no se usa por el @manyToOne
    @NotEmpty
    private int idVuelo;
    private int idCliente;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name="id_vuelo")
    @JoinColumn(name="id_cliente")
    Prereservas prereservas;
    
    public Prereservas() {
    }

    public Prereservas(Long idPrereserva, int idVuelo, int idCliente, boolean activo) {
        this.idPrereserva = idPrereserva;
        this.idVuelo = idVuelo;
        this.idCliente = idCliente;
        this.activo = activo;
    }

    public void setIdVuelo(int idVuelo, Long idPrereservas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Long getIdPrereserva() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIdCliente(int idCliente, Long idPrereservas1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean isActivo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
