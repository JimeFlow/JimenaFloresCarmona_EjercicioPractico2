package EjercicioPractico2.service.impl;

import EjercicioPractico2.dao.ReservasDao;
import EjercicioPractico2.domain.Reservas;
import EjercicioPractico2.service.ReservasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservasServiceImpl implements ReservasService {

    @Autowired
    private ReservasDao reservasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reservas> getReservas(boolean activos) {
        var lista = reservasDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Reservas getReserva(Reservas reservas) {
        return reservasDao.findById(reservas.getIdReserva()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reservas reservas) {
        reservasDao.save(reservas);
    }

    @Override
    @Transactional
    public void delete(Reservas reservas) {
        reservasDao.delete(reservas);
    }
    
    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada
    @Override
    @Transactional(readOnly = true)
    public List<Reservas> findByIdBetweenOrderByDescripcion(int idVuelo, int idCliente) {
        return reservasDao.findByIdBetweenOrderByDescripcion(idVuelo, idCliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservas> metodoJPQL(int idVuelo, int idCliente) {
        return reservasDao.metodoJPQL(idVuelo, idCliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservas> metodoNativo(int idVuelo, int idCliente) {
        return reservasDao.metodoNativo(idVuelo, idCliente);
    }
    
}
