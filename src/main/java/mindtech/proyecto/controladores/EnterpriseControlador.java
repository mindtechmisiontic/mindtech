
package mindtech.proyecto.controladores;

import mindtech.proyecto.Servicios.EnterpriseService;
import mindtech.proyecto.entidades.Enterprise;
import mindtech.proyecto.entidades.MensajeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseControlador {

    @GetMapping("/HolaEnterprise")
    public String info(){
        return "Hola Enterprise..";
    };

    @Autowired
    private EnterpriseService enterpriseService;
    public EnterpriseControlador(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    /*
    public EnterpriseService getEnterpriseService() {
        return enterpriseService;
    }

    public void setEnterpriseService(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }
*/  @PostMapping("/enterprises")
    public ResponseEntity<MensajeResponse> putEnterprise(@RequestBody Enterprise enterprise){
        return new ResponseEntity<>(
                new MensajeResponse("Enterprise Creado Exitosamente",
                        enterpriseService.putEnterprise(enterprise))
                ,HttpStatus.OK);
    }

    @GetMapping("/enterprises")
    public ResponseEntity<List<Enterprise>> getEnterprises(){
        return new ResponseEntity<List<Enterprise>>(
                enterpriseService.getEnterprises(),
                HttpStatus.OK
        );
    }

    @GetMapping ("enterprises/{id}")
    public ResponseEntity<Object> getEnterprise(@PathVariable Long id)
    {
        try{
            System.out.println("Metodo URL");
            Enterprise enterprise=enterpriseService.getEnterprise(id);
            return  new ResponseEntity<>(enterprise, HttpStatus.OK);

        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("enterprises/{id}")
    public ResponseEntity<MensajeResponse> patchEnterprise(@RequestBody Enterprise enterprise,@PathVariable Long id){
        try{
            System.out.println("Metodo Entrerprises/{id}/patch");
            return new ResponseEntity<>(new MensajeResponse("Actualizacion Exitosa",enterpriseService.patchEnterprise(enterprise, id)),HttpStatus.OK);
            }
        catch (Exception e)
        {
            return  new ResponseEntity<>(new MensajeResponse(e.getMessage(),null),HttpStatus.OK);
        }
    }
    @DeleteMapping("enterprises/{id}")
    public ResponseEntity<MensajeResponse> deleteEnterprise(@RequestBody Enterprise enterprise, @PathVariable Long id)
    {
        return new ResponseEntity<>(new MensajeResponse(enterpriseService.deleteEnterprise(id), null),HttpStatus.OK);

    }
    public EnterpriseControlador() {
    }




}
