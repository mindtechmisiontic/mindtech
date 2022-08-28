package mindtech.proyecto;

import entidades.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
		Enum_RoleName Er = null;
		Er =  Er.Administrador;
		//es posible crear una nueva instancia de la clase emmpleado
		System.out.println("Ceando nueva instancia... ");
		Employee emp =  new Employee( 1L, "Prueba11" );
		emp.toString();
		System.out.println(emp.toString());

		//Leer y modificar el nombre de un empleado
		System.out.println("Leyendo y modificando nombre... ");
		Enterprise empresa = new Enterprise("Mintic");
		Employee emp1 =  new Employee( 1L, "Prueba@gemail.com" , "Samir Humbertto Solano", empresa ,"Operadtivo");
		System.out.printf("nombre Actual : ");
		System.out.println(emp1.getName());
		System.out.printf("nombre Nuevo  : ");
		emp1.setName("Egan Bernal");
		System.out.println(emp1.getName());

		//Es posible leer y modificar el correo de un empleado
		System.out.println("Leyendo y modificando correo... ");
		System.out.printf("correo Actual : ");
		System.out.println(emp1.getEmail());
		emp1.setEmail("EganBernal@yoquevoyasaber.com");
		System.out.printf("correo Nuevo  : ");
		System.out.println(emp1.getEmail());

		//Es posible leer y modificar la empresa a la que el empleado pertenece
		System.out.println("Leyendo y modificando empresa... ");
		System.out.printf("empresa Actual : ");
		System.out.println(emp1.getEnterprise().getName());
		emp1.getEnterprise().setName("Monomeros Colombia S.A.");
		System.out.printf("empresa Nueva  : ");
		System.out.println(emp1.getEnterprise().getName());

		//Es posible leer y modificar el rol del empleado (administrador, operativo)
		System.out.println("Leyendo y modificando rol ... ");
		System.out.printf("rol Actual : ");
		System.out.println(emp1.getRol());
		emp1.setRol("Administrativo");
		System.out.printf("rol Nuevo  : ");
		System.out.println(emp1.getRol());

		//Es posible crear una nueva instancia de la clase transaction, leer y modificar atributos
		System.out.println("Ceando nueva instancia... ");
		Transaction mov1=new Transaction();
		mov1.setAmount(123);
		mov1.setConcept("compra 1");
		mov1.setUser(emp1);
		System.out.println("Saliendo ..");

		// Es posible crear una instancia de la clase "Empresa"
		System.out.println("");
		System.out.println("Creando instancia Enterprise...");
		Enterprise empresa2 = new Enterprise(2L,"Coca cola","1234", "873 4553", "calle 2-03");
		empresa2.toString();
		System.out.println("Leyendo datos actuales...");
		System.out.println(empresa2.toString());
		//Es posible modificar los atributos
		System.out.println("Modificando atributos...");
		empresa2.setName("Pepsi");
		empresa2.setDocument("4321");
		empresa2.setPhone("984 5664");
		empresa2.setAddress("Diag 3-02");
		System.out.println("Leyendo atributos modificados....");
		empresa2.toString();
		System.out.println(empresa2.toString());
		System.out.println("Saliendo");
	}

}
