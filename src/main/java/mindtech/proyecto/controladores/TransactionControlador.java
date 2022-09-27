package mindtech.proyecto.controladores;

import mindtech.proyecto.Servicios.ProfileService;
import mindtech.proyecto.Servicios.TransactionService;
import mindtech.proyecto.entidades.MensajeResponse;
import mindtech.proyecto.entidades.Profile;
import mindtech.proyecto.entidades.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionControlador {

    @GetMapping("/HolaTransaccion")
    public String info(){
        return "Hola Transaccion..";
    };

    @Autowired
    private TransactionService  transactionService;

/*
    public ProfileService getProfileService() {
        return profileService;
    }


    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }
*/
    @PostMapping("/Transaccion")
    public ResponseEntity<MensajeResponse> postprofile(@RequestBody Transaction transaction){
        return new ResponseEntity<>(

                new MensajeResponse("Transaccion Creado Exitosamente",
                        transactionService.saveTransaction(transaction))

                ,HttpStatus.OK);
    }

    @GetMapping("/Transaccion")
    public ResponseEntity<List<Transaction>> getTransactions(){
        return new ResponseEntity<List<Transaction>>(
                transactionService.getTransactions(),
                HttpStatus.OK
        );
    }


    @GetMapping("/enterprises/{id}/movements")
    public ResponseEntity<Object> getMovimientos(@PathVariable Long id){

        try {
            System.out.println("Metodo Url");
            Transaction transaction = transactionService.getTranscationId(id);
            return new ResponseEntity<>(transaction,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/enterprises/{id}/patch")
    public ResponseEntity<MensajeResponse> patch(@RequestBody Transaction transaction, @PathVariable Long id){
        try {
            System.out.println("Metodo enterprises/{id}/patch");
            return new ResponseEntity<>(
                    new MensajeResponse("Actualizacion Exitosa", transactionService.patchTransaction(transaction, id)),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new MensajeResponse(e.getMessage(), null),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping("/Transaccion/{id}/delete")
    public ResponseEntity<MensajeResponse> delete(@PathVariable Long id){
        return new ResponseEntity<>(

                new MensajeResponse(transactionService.delete(id), null),
                HttpStatus.OK
        );
    }

}
