package JimenaFloresCarmona_EjercicioPractico2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PracticaEjercicioPractico2Application {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(PracticaEjercicioPractico2Application.class, args);
    }

}
