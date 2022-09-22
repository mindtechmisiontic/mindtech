package mindtech.proyecto.controladores;

import mindtech.proyecto.Servicios.ProfileService;
import mindtech.proyecto.Servicios.TransactionService;
import mindtech.proyecto.entidades.MensajeResponse;
import mindtech.proyecto.entidades.Profile;
import mindtech.proyecto.entidades.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
