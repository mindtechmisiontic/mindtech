package mindtech.proyecto.controladores;

import mindtech.proyecto.Servicios.ProfileService;
import mindtech.proyecto.entidades.MensajeResponse;
import mindtech.proyecto.entidades.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileControlador {

    @GetMapping("/Hola")
    public String info(){
        return "Hola Profiles..";
    };




    @Autowired
    private ProfileService profileService;

    public ProfileService getProfileService() {
        return profileService;
    }

    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/Profile")
    public ResponseEntity<MensajeResponse> postprofile(@RequestBody Profile profile){
        return new ResponseEntity<>(

                new MensajeResponse("profile Creado Exitosamente",
                        profileService.saveProfile(profile))

                ,HttpStatus.OK);
    }

    @GetMapping("/Profile")
    public ResponseEntity<List<Profile>> getProfiles(){
        return new ResponseEntity<List<Profile>>(
                profileService.getProfiles(),
                HttpStatus.OK
        );
    }


}
