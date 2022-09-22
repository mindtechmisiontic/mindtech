
package mindtech.proyecto.controladores;

import mindtech.proyecto.Servicios.EnterpriseService;
import mindtech.proyecto.entidades.Enterprise;
import mindtech.proyecto.entidades.MensajeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnterpriseControlador {

    @GetMapping("/HolaEnterprise")
    public String info(){
        return "Hola Enterprise..";
    };

    @Autowired
    private EnterpriseService enterpriseService;

    public EnterpriseService getEnterpriseService() {
        return enterpriseService;
    }

    public void setEnterpriseService(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    public EnterpriseControlador(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    public EnterpriseControlador() {
    }

    @GetMapping("/Enterprise")
    public ResponseEntity<List<Enterprise>> getEnterprises(){
        return new ResponseEntity<List<Enterprise>>(
                enterpriseService.getEnterprises(),
                HttpStatus.OK
        );
    }

    @PostMapping("/Enterprise")
    public ResponseEntity<MensajeResponse> postEmploye(@RequestBody Enterprise enterprise){
        return new ResponseEntity<>(
                new MensajeResponse("Enterprise Creado Exitosamente",
                        enterpriseService.saveEnterprise(enterprise))
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
