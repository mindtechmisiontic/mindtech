
package mindtech.proyecto.entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name ="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String rol;

    @JoinColumn(name = "role_ID")
    @Enumerated(value = EnumType.STRING)
    private Enum_RoleName role;

    @JoinColumn(name="profile_id")
    @OneToOne()
    private Profile profile;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "employee")
    //@JoinColumn(name="transaction_id")
    private List<Transaction> transaction;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", rol='" + rol + '\'' +
                ", role=" + role +
                ", profile=" + profile +
                ", transaction=" + transaction +
                '}';
    }

    public Employee(Long id, String email, String name, String rol, Enum_RoleName role, Profile profile, List<Transaction> transaction) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.rol = rol;
        this.role = role;
        this.profile = profile;
        this.transaction = transaction;
    }

    public Employee(){
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

