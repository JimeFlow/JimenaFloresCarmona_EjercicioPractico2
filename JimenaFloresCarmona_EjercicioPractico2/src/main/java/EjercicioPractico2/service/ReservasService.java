package EjercicioPractico2.service;

import EjercicioPractico2.domain.Reservas;
import java.util.List;

public interface ReservasService {

    public List<Reservas> getReservas(boolean activo);

    // Se obtiene un Producto, a partir del id de un producto
    public Reservas getReserva(Reservas reservas);

    // Se inserta un nuevo producto si el id del producto esta vacío
    // Se actualiza un producto si el id del producto NO esta vacío
    public void save(Reservas reservas);

    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Reservas reservas);
    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada

    public List<Reservas> findByIdBetweenOrderByDescripcion(int idVuelo, int idCliente);

    //Lista de productos utilizando consultas con JPQL    
    public List<Reservas> metodoJPQL(int idVuelo, int idCliente);

    //Lista de productos utilizando consultas con SQL Nativo
    public List<Reservas> metodoNativo(int idVuelo, int idCliente);

}
