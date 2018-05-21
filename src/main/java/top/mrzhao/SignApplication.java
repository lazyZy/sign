package top.mrzhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath:spring/spring-all.xml"})
@SpringBootApplication
public class SignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignApplication.class, args);
	}
}
