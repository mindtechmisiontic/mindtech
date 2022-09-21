/*
package Servicios;

import entidades.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import repositorio.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeRepository;

    public EmployeeService(EmployeeRepository employeRepository){
        this.employeRepository= employeRepository;
    }
    public List<Employee>  getEmployees() {
        return employeRepository.findAll();
    }

    public EmployeeService() {
    }

    public Employee getEmployee(String id) throws Exception {
        Optional<Employee> employeeOptional = employeRepository.findById(id);
        if(employeeOptional.isPresent()){
            return employeeOptional.get();
        }else{
            throw new Exception("employee No Existe");
        }
    }

    public Employee saveEmployee(Employee employee_param){
        return employeRepository.save(employee_param);
    }

    public Employee putEmployee(Employee employee_param){
        return employeRepository.save(employee_param);
    }

    public Employee patchEmployee(Employee employee_param, String id) throws Exception {
        try {
            Employee employeeBd = getEmployee(id);

            if(employee_param.getName() != null){
                employeeBd.setName(employee_param.getName());
            }
            if(employee_param.getRol() != null){
                employeeBd.setRol(employee_param.getRol());
            }

            return saveEmployee(employeeBd);

        } catch (Exception e) {
            throw new Exception("Employee no se actualizo, porque no existe");
        }
    }

    public String delete(String id){
        employeRepository.deleteById(id);
        return "Employee eliminado Exitosamente";
    }




}
*/