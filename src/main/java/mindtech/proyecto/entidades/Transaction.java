
package mindtech.proyecto.entidades;


import  javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="transaccion")
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "concept")
    private String concept;
    @Column(name = "amount")
    private float amount;
//    @Column(name = "user")
//    @ManyToOne
//    @JoinColumn(name="employee_id")
//    private Employee user;
//    @Column(name = "enterprise")
    @Column(name = "createAt")
    private String createAt;
    @Column(name = "updatedAt")
    private String updatedAt;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name="enterprise_id")
    private Enterprise enterprise;

    public Transaction(Long id, String concept, float amount, String createAt, String updatedAt, Employee employee, Enterprise enterprise) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
        this.employee = employee;
        this.enterprise = enterprise;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", concept='" + concept + '\'' +
                ", amount=" + amount +
                ", createAt=" + createAt +
                ", updatedAt=" + updatedAt +
                ", employee=" + employee +
                ", enterprise=" + enterprise +
                '}';
    }

    public Transaction(){

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }



    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}


