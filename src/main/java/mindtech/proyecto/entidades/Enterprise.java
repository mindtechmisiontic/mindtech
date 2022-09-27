
package mindtech.proyecto.entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name ="enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String document;
    @Column
    private String phone;
    @Column
    private String address;
    @Column
    private String createAt;
    @Column
    private String updatedAt;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "enterprise")
    private List<Transaction> transaction;
    public Enterprise() {
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createAt='" + createAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", transaction=" + transaction +
                '}';
    }

    public Enterprise(Long id, String name, String document, String phone, String address, String createAt, String updatedAt, List<Transaction> transaction) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
        this.transaction = transaction;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }
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
    public Enterprise(String name) {
        this.name = name;
    }

}
