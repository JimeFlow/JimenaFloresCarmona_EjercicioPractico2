package EjercicioPractico2.service.impl;


import EjercicioPractico2.domain.Vuelos;
import EjercicioPractico2.service.VuelosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import EjercicioPractico2.dao.VuelosDao;

@Service
public class VuelosServiceImpl implements VuelosService {
    
    @Autowired
    private VuelosDao vuelosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Vuelos> getVuelos(boolean activos) {
        var lista = vuelosDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Vuelos getVuelos(Vuelos vuelos) {
        return vuelosDao.findById(vuelos.getIdVuelo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Vuelos vuelos) {
        vuelosDao.save(vuelos);
    }

    @Override
    @Transactional
    public void delete(Vuelos vuelos) {
        vuelosDao.delete(vuelos);
    }
    
}
