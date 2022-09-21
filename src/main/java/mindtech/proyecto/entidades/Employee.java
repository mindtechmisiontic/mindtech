
package mindtech.proyecto.entidades;
//import mindtech.proyecto.entidades.Enterprise;
//import mindtech.proyecto.entidades.Transaction;

import javax.persistence.*;
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

    @JoinColumn(name="Profile_id")
    @OneToOne()
    private Profile profile;

//    @ManyToOne
//    @JoinColumn(name="enterprise_id")
//    private Enterprise enterprise;

    @OneToMany(mappedBy = "employee")
    private List<Transaction> Transaction;

    public Employee(){
    }

    public Employee(Long id, String email, String name, String rol, Enum_RoleName role, Profile profile, List<mindtech.proyecto.entidades.Transaction> transaction) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.rol = rol;
        this.role = role;
        this.profile = profile;
        Transaction = transaction;
    }

    public List<mindtech.proyecto.entidades.Transaction> getTransaction() {
        return Transaction;
    }

    public void setTransaction(List<mindtech.proyecto.entidades.Transaction> transaction) {
        Transaction = transaction;
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
/*
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
*/
}

