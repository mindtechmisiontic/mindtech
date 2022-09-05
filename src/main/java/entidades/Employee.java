package entidades;
import org.hibernate.loader.plan.spi.Return;

import javax.persistence.*;
import java.util.List;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String email;
    private String name;
    private String rol;

    @Enumerated(EnumType.STRING)
    private Enum_RoleName role;

    @ManyToOne
    @JoinColumn(name="enterprise_id")
    private Enterprise enterprise;
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactionList;

    public Employee(Long id, String email, String name, Enterprise enterprise,String rol) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.enterprise = enterprise;
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    public Employee(Long id, String email) {
        this.id = id;
        this.email = email;
        this.toString();

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

    public Employee(){


    }
}
