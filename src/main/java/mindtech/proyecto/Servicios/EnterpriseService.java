
package mindtech.proyecto.Servicios;

import mindtech.proyecto.entidades.Employee;
import mindtech.proyecto.entidades.Enterprise;
import mindtech.proyecto.repositorio.EnterpriseRepository;
import net.bytebuddy.asm.Advice;
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

    public EnterpriseService() {
    }


    public List<Enterprise>  getEnterprises() {
        return enterpriseRepository.findAll();
    }



    public Enterprise getEnterprise(Long id) throws Exception {
        Optional<Enterprise> enterpriseOptional = enterpriseRepository.findById(id);
        if(enterpriseOptional.isPresent()){
            return enterpriseOptional.get();
        }else{
            throw new Exception("Enterprise No Existe");
        }
    }



    public Enterprise putEnterprise(Enterprise enterprise_param){

        return enterpriseRepository.save(enterprise_param);
    }

    public Enterprise patchEnterprise(Enterprise enterprise_param, Long id) throws Exception
    {
        try{
            Enterprise enterprisePatch = getEnterprise(id);
            if(enterprise_param.getName()!=null){
                enterprisePatch.setName(enterprise_param.getName());
            }
            if(enterprise_param.getDocument()!=null){
                enterprisePatch.setDocument(enterprise_param.getDocument());
            }
            if(enterprise_param.getPhone()!=null){
                enterprisePatch.setPhone(enterprise_param.getPhone());
            }
            if(enterprise_param.getAddress()!=null){
                enterprisePatch.setAddress(enterprise_param.getAddress());
            }
            return putEnterprise(enterprisePatch);
        }catch (Exception e){
            throw new Exception("No se actualizo, no existe");
        }
    }

    public String deleteEnterprise(Long id)
    {
        enterpriseRepository.deleteById(id);
        return "Empresa Eliminada";
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
