package entidades;
import javax.persistence.*;
import java.util.Date;
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
    private Date createAt;
    private Date updatedAt;
    public Enterprise(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getUsers() {
        return users;
    }

    public void setUsers(List<Employee> users) {
        this.users = users;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Enterprise(String name) {
        this.name = name;
    }
}
