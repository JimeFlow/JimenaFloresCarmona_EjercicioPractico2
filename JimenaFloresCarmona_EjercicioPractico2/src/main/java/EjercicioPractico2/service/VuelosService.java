package EjercicioPractico2.service;

import EjercicioPractico2.domain.Vuelos;
import java.util.List;

public interface VuelosService {
    
    public List<Vuelos> getVuelos(boolean activo);

    // Se obtiene un Vuelo, a partir del id de un vuelo
    public Vuelos getVuelos(Vuelos vuelos);
    
    // Se inserta un nuevo vuelo si el id del vuelo esta vacío
    // Se actualiza un vuelo si el id del vuelo NO esta vacío
    public void save(Vuelos vuelos);
    
    // Se elimina el vuelo que tiene el id pasado por parámetro
    public void delete(Vuelos vuelos);
    
}
