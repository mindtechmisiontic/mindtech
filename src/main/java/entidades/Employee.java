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
    private String nombreEmpleado;
    private String rol;
    @ManyToOne
    @JoinColumn(name="enterprise_id")
    private Enterprise enterprise;
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactionList;

    public Employee(Long id, String email, String nombreEmpleado, Enterprise enterprise,String rol) {
        this.id = id;
        this.email = email;
        this.nombreEmpleado = nombreEmpleado;
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

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
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

    public Employee(){}
}
