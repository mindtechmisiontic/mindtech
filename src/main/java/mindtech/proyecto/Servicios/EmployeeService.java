
package mindtech.proyecto.Servicios;

import mindtech.proyecto.entidades.Employee;
import mindtech.proyecto.entidades.Transaction;
import mindtech.proyecto.repositorio.EmployeeRepository;
import mindtech.proyecto.repositorio.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TransactionService  transactionService;


    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    public EmployeeService() {
    }
    public List<Employee>  getEmployees() {
        return employeeRepository.findAll();
    }



    public Employee getEmployee(Long id) throws Exception {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            return employeeOptional.get();
        }else{
            throw new Exception("employee No Existe");
        }
    }

   public Employee putEmployee(Employee employee_param){
        return employeeRepository.save(employee_param);
    }

    public Employee patchEmployee(Employee employee_param, Long id) throws Exception {
        try {
            Employee employeePatch = getEmployee(id);

            if(employee_param.getEmail() != null){
                employeePatch.setEmail(employee_param.getEmail());
            }
            if(employee_param.getName() != null){
                employeePatch.setName(employee_param.getName());
            }
            if(employee_param.getRol() != null){
                employeePatch.setRol(employee_param.getRol());
            }
            if(employee_param.getRole() != null){
                employeePatch.setRole(employee_param.getRole());
            }
            if(employee_param.getProfile() != null){
                employeePatch.setProfile(employee_param.getProfile());
            }
            if(employee_param.getTransaction() != null){
                employeePatch.setTransaction(employee_param.getTransaction());
            }

            return putEmployee(employeePatch);

        } catch (Exception e) {
            throw new Exception("Employee no se actualizo, porque no existe");
        }
    }

    public String deleteEmployee(Long id){                      
        List<Transaction> movs = transactionService.getTransactions();
        for (Transaction mov: movs) {
            if(mov.getEmployee().getId()==id)
            {
                transactionService.delete(mov.getId());
            }
        }
        
        employeeRepository.deleteById(id);
        return "Employee eliminado Exitosamente";
    }




}
