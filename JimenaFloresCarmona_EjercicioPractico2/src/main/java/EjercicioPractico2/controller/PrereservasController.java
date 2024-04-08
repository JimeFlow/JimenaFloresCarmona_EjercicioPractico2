package EjercicioPractico2.controller;

import EjercicioPractico2.domain.Prereservas;
import EjercicioPractico2.service.VuelosService;
import EjercicioPractico2.service.PrereservasService;
//import com.tienda.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/preresrevas")
public class PrereservasController {
  
    @Autowired
    private PrereservasService prereservasService;
    @Autowired
    private VuelosService vuelosService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var prereservas = prereservasService.getPrereservas(false);
        model.addAttribute("prereservas", prereservas);
        
        var vuelos = vuelosService.getVuelos(false);
        model.addAttribute("vuelos", vuelos);
        
        model.addAttribute("totalPrereservas",prereservas.size());
        return "/prereservas/listado";
    }
    
     @GetMapping("/nuevo")
    public String prereservasNuevo(Prereservas prereservas) {
        return "/prereservas/modifica";
    }

    @Autowired
    //private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String prereservasGuardar(Prereservas prereservas,
            @RequestParam("idVuelo") int idVuelo,
            @RequestParam("idCliente") int idCliente) {
        if (idVuelo != 0 && idCliente != 0) {
            prereservasService.save(prereservas);
            prereservas.setIdVuelo(idVuelo, 
                    prereservas.getIdPrereserva());
            prereservas.setIdCliente(idCliente,
                    prereservas.getIdPrereserva());
        }
        prereservasService.save(prereservas);
        return "redirect:/prereservas/listado";
    }

    @GetMapping("/eliminar/{idPrereserva}")
    public String prereservasEliminar(Prereservas prereservas) {
        prereservasService.delete(prereservas);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idPrereserva}")
    public String productoModificar(Prereservas prereservas, Model model) {
        prereservas = prereservasService.getPrereserva(prereservas);
        model.addAttribute("prereservas", prereservas);
        
        var vuelos = vuelosService.getVuelos(false);
        model.addAttribute("vuelos", vuelos);
        
        return "/prereservas/modifica";
    }   
    
}