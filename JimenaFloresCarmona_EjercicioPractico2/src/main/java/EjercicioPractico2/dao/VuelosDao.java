package EjercicioPractico2.dao;

import EjercicioPractico2.domain.Vuelos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VuelosDao extends JpaRepository <Vuelos, Long> {
    
}
