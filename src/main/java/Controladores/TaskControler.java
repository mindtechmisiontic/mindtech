package Controladores;

import entidades.Employee;
import org.hibernate.sql.Template;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class TaskControler {
    AtomicLong val = new AtomicLong(0);
    private static final String plantilla = "Prueba Primera";

    @GetMapping("/tarea")
    public Employee Employee(@RequestParam(value = "email", defaultValue = "mundoooo") Long id, @RequestParam String name){
        System.out.println("Entrando");
         Employee emp =  new Employee( );
        emp.toString();
        return emp ;
    }


}
