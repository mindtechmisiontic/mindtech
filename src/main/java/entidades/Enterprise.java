package entidades;
import javax.persistence.*;
import java.util.List;
@Entity
public class Enterprise {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String document;
    private String phone;
    private String address;
    @OneToMany(mappedBy = "enterprise")
    private List<Employee> users;
    @OneToMany(mappedBy = "enterprise")
    private List<Transaction> transactionList;

    public Enterprise(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enterprise(String name) {
        this.name = name;
    }
}
