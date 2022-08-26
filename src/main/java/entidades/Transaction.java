package entidades;
import  javax.persistence.*;
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String concept;
    private float amount;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee user;
    @ManyToOne
    @JoinColumn(name="enterprise_id")
    private Enterprise enterprise;
    public Transaction(){}
}
