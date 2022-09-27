
package mindtech.proyecto.controladores;

import mindtech.proyecto.Servicios.EmployeeService;
import mindtech.proyecto.entidades.Employee;
import mindtech.proyecto.entidades.MensajeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class EmployeeControlador {

    @GetMapping("/HolaEmployee")
    public String info(){
        return "Hola Employee..";
    };

    @Autowired
    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeControlador(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeControlador() {
    }

    @GetMapping("/Employee")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<List<Employee>>(
                employeeService.getEmployees(),
                HttpStatus.OK
        );
    }

    @PostMapping("/Employee")
    public ResponseEntity<MensajeResponse> postEmploye(@RequestBody Employee employee){
        return new ResponseEntity<>(
                new MensajeResponse("Employee Creado Exitosamente",
                        employeeService.saveEmployee(employee))
                ,HttpStatus.OK);
    }
/*
    @GetMapping("/Employee/{id}")
    public ResponseEntity<Employee>  getEmploye(@PathVariable String id){
        try {
            System.out.println("Metodo Url");
        } catch (Exception e) {
        }
    }
*/

}