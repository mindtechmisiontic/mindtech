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
		Enterprise empresa1=new Enterprise();
		empresa1.setName("Mindtech");
		empresa1.setAddress("calle 1 carrera 2");
		empresa1.setPhone("123213");
		empresa1.setDocument("1111110");
		Employee empleado1=new Employee();
		empleado1.setName("pepito");
		empleado1.setEmail("pepito@correo.com");
		empleado1.setEnterprise(empresa1);
		Enum_RoleName Er = null;
		Er =  Er.Administrador;;
		empleado1.setRole(Er);
		Profile perfil1=new Profile();
		perfil1.setImage("asdasd");
		perfil1.setPhone("123123");
		perfil1.setUser(empleado1);
		Transaction mov1=new Transaction();
		mov1.setAmount(123);
		mov1.setConcept("compra 1");
		mov1.setUser(empleado1);
		System.out.println("hola");

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

		System.out.println("Saliendo ..");




	}

}
