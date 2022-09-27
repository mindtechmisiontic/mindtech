
package mindtech.proyecto.controladores;

import mindtech.proyecto.Servicios.EmployeeService;
import mindtech.proyecto.entidades.Employee;
import mindtech.proyecto.entidades.Enterprise;
import mindtech.proyecto.entidades.MensajeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class EmployeeControlador {

    @GetMapping("/HolaEmployee")
    public String info(){
        return "Hola Employee..";
    };

    @Autowired
    private EmployeeService employeeService;
    public EmployeeControlador(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    @PostMapping("/employee")
    public ResponseEntity<MensajeResponse> postEmploye(@RequestBody Employee employee){
        return new ResponseEntity<>(
                new MensajeResponse("Employee Creado Exitosamente",
                        employeeService.putEmployee(employee))
                ,HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<List<Employee>>(
                employeeService.getEmployees(),
                HttpStatus.OK
        );
    }

    @GetMapping ("employee/{id}")
    public ResponseEntity<Object> getEnterprise(@PathVariable Long id)
    {
        try{
            System.out.println("Metodo URL");
            Employee employee=employeeService.getEmployee(id);
            return  new ResponseEntity<>(employee, HttpStatus.OK);

        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("employee/{id}")
    public ResponseEntity<MensajeResponse> patchEmployee(@RequestBody Employee employee,@PathVariable Long id){
        try{
            System.out.println("Metodo Employee/{id}/patch");
            return new ResponseEntity<>(new MensajeResponse("Actualizacion Exitosa",employeeService.patchEmployee(employee, id)),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return  new ResponseEntity<>(new MensajeResponse(e.getMessage(),null),HttpStatus.OK);
        }
    }
    @DeleteMapping("employee/{id}")
    public ResponseEntity<MensajeResponse> deleteEmployee(@RequestBody Employee employee, @PathVariable Long id)
    {
        return new ResponseEntity<>(new MensajeResponse(employeeService.deleteEmployee(id), null),HttpStatus.OK);

    }


    public EmployeeControlador() {
    }





}
