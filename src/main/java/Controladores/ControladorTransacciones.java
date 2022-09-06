package Controladores;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class ControladorTransacciones {


    public static void main(String[] args) {
        SpringApplication.run(ControladorTransacciones.class, args);
    }

    @GetMapping("/enterprises/[id]/movements/")
    public String hello(@RequestParam(value = "id", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

}
