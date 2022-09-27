package mindtech.proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name ="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private String usuario;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private Profile profile;

    public Usuario() {
    }

    public Usuario(Long id, String usuario, Profile profile) {
        this.id = id;
        this.usuario = usuario;
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", profile=" + profile +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}


