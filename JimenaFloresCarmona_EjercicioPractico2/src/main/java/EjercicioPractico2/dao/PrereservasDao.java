package EjercicioPractico2.dao;

import EjercicioPractico2.domain.Prereservas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrereservasDao extends JpaRepository <Prereservas, Long> {
    
    //Ejemplo de método utilizando Métodos de Query
    public List<Prereservas> findByIdBetweenOrderByDescripcion(int idVuelo, int idCliente);

    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value = "SELECT a FROM Producto a where a.id BETWEEN :idVuelo AND :idCliente ORDER BY a.descripcion ASC")
    public List<Prereservas> metodoJPQL(@Param("idVuelo") int idVuelo, @Param("idCliente") int idCliente);

    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery = true,
            value = "SELECT * FROM producto where prereservas.id BETWEEN :idVuelo AND :idCliente ORDER BY prereservas.descripcion ASC")
    public List<Prereservas> metodoNativo(@Param("idVuelo") int idVuelo, @Param("idCliente") int idCliente);

}
