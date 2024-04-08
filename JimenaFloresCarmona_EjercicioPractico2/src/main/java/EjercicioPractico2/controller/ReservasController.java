package EjercicioPractico2.controller;

import EjercicioPractico2.domain.Reservas;
import EjercicioPractico2.service.VuelosService;
import EjercicioPractico2.service.ReservasService;
//import com.tienda.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservas")
public class ReservasController {
  
    @Autowired
    private ReservasService reservasService;
    @Autowired
    private VuelosService vuelosService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var reservas = reservasService.getReservas(false);
        model.addAttribute("reservas", reservas);
        
        var vuelos = vuelosService.getVuelos(false);
        model.addAttribute("vuelos", vuelos);
        
        model.addAttribute("totalReservas",reservas.size());
        return "/reservas/listado";
    }
    
     @GetMapping("/nuevo")
    public String reservasNuevo(Reservas reservas) {
        return "/reservas/modifica";
    }

    @Autowired
    //private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String reservasGuardar(Reservas reservas,
            @RequestParam("idVuelo") int idVuelo,
            @RequestParam("idCliente") int idCliente) {
        if (idVuelo != 0 && idCliente != 0) {
            reservasService.save(reservas);
            reservas.setIdVuelo(idVuelo, 
                    reservas.getIdReserva());
            reservas.setIdCliente(idCliente,
                    reservas.getIdReserva());
        }
        reservasService.save(reservas);
        return "redirect:/reservas/listado";
    }

    @GetMapping("/eliminar/{idPrereserva}")
    public String prereservasEliminar(Reservas reservas) {
        reservasService.delete(reservas);
        return "redirect:/reservas/listado";
    }

    @GetMapping("/modificar/{idReserva}")
    public String reservasModificar(Reservas reservas, Model model) {
        reservas = reservasService.getReserva(reservas);
        model.addAttribute("reservas", reservas);
        
        var vuelos = vuelosService.getVuelos(false);
        model.addAttribute("vuelos", vuelos);
        
        return "/prereservas/modifica";
    }   
    
}