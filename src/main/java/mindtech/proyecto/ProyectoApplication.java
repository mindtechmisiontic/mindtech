package mindtech.proyecto;

import entidades.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProyectoApplication.class, args);
		Enterprise empresa1=new Enterprise();
		empresa1.setName("Mindtech");
		empresa1.setAddress("calle 1 carrera 2");
		empresa1.setPhone("123213");
		empresa1.setDocument("1111110");
		Employee empleado1=new Employee();
		empleado1.setName("pepito");
		empleado1.setEmail("pepito@correo.com");
		empleado1.setEnterprise(empresa1);
		empleado1.setRole(Enum_RoleName.Administrador);
		Profile perfil1=new Profile();
		perfil1.setImage("asdasd");
		perfil1.setPhone("123123");
		perfil1.setUser(empleado1);
		Transaction mov1=new Transaction();
		mov1.setAmount(123);
		mov1.setConcept("compra 1");
		mov1.setUser(empleado1);
		System.out.println("hola");

	}

}
