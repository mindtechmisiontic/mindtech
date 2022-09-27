package mindtech.proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name ="profile")
public class Profile {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column
    private String image;
    @Column
    private String phone;

    //@JsonIgnore
    //@JoinColumn(name="usuario")
    @OneToOne()
    private Usuario usuario;

    @Column
    private String createAt;
    @Column
    private String updatedAt;
    @JsonIgnore
    @OneToOne(mappedBy = "profile" )
    private Employee employee;

    public Profile(Long id, String image, String phone, Usuario usuario, String createAt, String updatedAt, Employee employee) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.usuario = usuario;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
        this.employee = employee;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Profile(){

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
