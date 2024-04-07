package EjercicioPractico2.controller;

import EjercicioPractico2.domain.Vuelos;
import EjercicioPractico2.service.VuelosService;
//import com.tienda.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vuelos")
public class VuelosController {
    @Autowired
    private VuelosService vuelosService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var vuelos = vuelosService.getVuelos(false);
        model.addAttribute("vuelos", vuelos);
        model.addAttribute("totalVuelos", vuelos.size());
        return "/vuelos/listado";
    }
    
     @GetMapping("/nuevo")
    public String vuelosNuevo(Vuelos vuelos) {
        return "/vuelos/modifica";
    }

    @Autowired
    //private FirebaseStorageServiceImpl firebaseStorageService;
    
    
    @PostMapping("/guardar")
    public String vuelosGuardar(Vuelos vuelos,
            @RequestParam("rutaVuelo") String rutaVuelo) {        
        if (rutaVuelo != null && !rutaVuelo.isEmpty()) {
            vuelosService.save(vuelos);
            vuelos.setDestino(rutaVuelo);
        }
        vuelosService.save(vuelos);
        return "redirect:/vuelos/listado";
    }

    @GetMapping("/eliminar/{idVuelo}")
    public String vuelosEliminar(Vuelos vuelos) {
        vuelosService.delete(vuelos);
        return "redirect:/vuelos/listado";
    }

    @GetMapping("/modificar/{idVuelo}")
    public String vuelosModificar(Vuelos vuelos, Model model) {
        vuelos = vuelosService.getVuelos(vuelos);
        model.addAttribute("vuelos", vuelos);
        return "/vuelos/modifica";
    }   
}
