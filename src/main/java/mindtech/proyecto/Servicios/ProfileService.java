package mindtech.proyecto.Servicios;

import mindtech.proyecto.entidades.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import repositorio.EmployeeRepository;
import mindtech.proyecto.repositorio.ProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileService() {
    }

    public Profile saveProfile(Profile profile_param){
        return profileRepository.save(profile_param);
    }
    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfile(Long id) throws Exception {
        Optional<Profile> ProfileOptional = profileRepository.findById(id);
        if(ProfileOptional.isPresent()){
            return ProfileOptional.get();
        }else{
            throw new Exception("Profile No Existe");
        }
    }

}
