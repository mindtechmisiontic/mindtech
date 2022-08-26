package entidades;
import javax.persistence.*;
import java.util.List;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String email;
    @ManyToOne
    @JoinColumn(name="enterprise_id")
    private Enterprise enterprise;
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactionList;

    public Employee(){}
}
