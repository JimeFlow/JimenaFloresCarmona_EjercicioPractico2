package EjercicioPractico2.service;

import EjercicioPractico2.domain.Prereservas;
import java.util.List;

public interface PrereservasService {

    public List<Prereservas> getPrereservas(boolean activo);

    // Se obtiene un Producto, a partir del id de un producto
    public Prereservas getPrereserva(Prereservas prereservas);

    // Se inserta un nuevo producto si el id del producto esta vacío
    // Se actualiza un producto si el id del producto NO esta vacío
    public void save(Prereservas prereservas);

    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Prereservas prereservas);
    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada

    public List<Prereservas> findByIdBetweenOrderByDescripcion(int idVuelo, int idCliente);

    //Lista de productos utilizando consultas con JPQL    
    public List<Prereservas> metodoJPQL(int idVuelo, int idCliente);

    //Lista de productos utilizando consultas con SQL Nativo
    public List<Prereservas> metodoNativo(int idVuelo, int idCliente);

}
