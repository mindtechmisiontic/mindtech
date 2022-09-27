
package mindtech.proyecto.repositorio;


import mindtech.proyecto.entidades.Employee;
import mindtech.proyecto.entidades.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Long> {

}
