package EjercicioPractico2.service.impl;

import EjercicioPractico2.dao.PrereservasDao;
import EjercicioPractico2.domain.Prereservas;
import EjercicioPractico2.service.PrereservasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrereservasServiceImpl implements PrereservasService {

    @Autowired
    private PrereservasDao prereservasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Prereservas> getPrereservas(boolean activos) {
        var lista = prereservasDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Prereservas getPrereserva(Prereservas prereservas) {
        return prereservasDao.findById(prereservas.getIdPrereserva()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Prereservas prereservas) {
        prereservasDao.save(prereservas);
    }

    @Override
    @Transactional
    public void delete(Prereservas prereservas) {
        prereservasDao.delete(prereservas);
    }
    
    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada
    @Override
    @Transactional(readOnly = true)
    public List<Prereservas> findByIdBetweenOrderByDescripcion(int idVuelo, int idCliente) {
        return prereservasDao.findByIdBetweenOrderByDescripcion(idVuelo, idCliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Prereservas> metodoJPQL(int idVuelo, int idCliente) {
        return prereservasDao.metodoJPQL(idVuelo, idCliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Prereservas> metodoNativo(int idVuelo, int idCliente) {
        return prereservasDao.metodoNativo(idVuelo, idCliente);
    }
    
}
