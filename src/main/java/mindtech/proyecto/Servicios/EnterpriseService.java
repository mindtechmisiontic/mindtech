
package mindtech.proyecto.Servicios;

import mindtech.proyecto.entidades.Employee;
import mindtech.proyecto.entidades.Enterprise;
import mindtech.proyecto.repositorio.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public EnterpriseService(EnterpriseRepository enterpriseRepository){
        this.enterpriseRepository= enterpriseRepository;
    }
    public List<Enterprise>  getEnterprises() {
        return enterpriseRepository.findAll();
    }

    public EnterpriseService() {
    }

    public Enterprise getEmployee(String id) throws Exception {
        Optional<Enterprise> employeeOptional = enterpriseRepository.findById(id);
        if(employeeOptional.isPresent()){
            return employeeOptional.get();
        }else{
            throw new Exception("Enterprise No Existe");
        }
    }

    public Enterprise saveEnterprise(Enterprise enterprise_param){
        return enterpriseRepository.save(enterprise_param);
    }

    public Enterprise putEnterprise(Enterprise enterprise_param){
        return enterpriseRepository.save(enterprise_param);
    }
/*
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

*/


}
