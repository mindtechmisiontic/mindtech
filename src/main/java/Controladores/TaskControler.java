package Controladores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@SpringBootApplication
@RestController
public class TaskControler {
    AtomicLong val = new AtomicLong(0);
    private static final String plantilla = "Prueba Primera";

    public static void main(String[] args) {
        SpringApplication.run(TaskControler.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


    /*
    @GetMapping("/tarea")
    public Employee Employee(@RequestParam(value = "email", defaultValue = "mundoooo") Long id, @RequestParam String name){
        System.out.println("Entrando");
         Employee emp =  new Employee( );
        emp.toString();
        return emp ;
    }
*/

}
