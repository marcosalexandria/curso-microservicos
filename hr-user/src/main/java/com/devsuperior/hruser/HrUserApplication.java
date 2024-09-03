package com.devsuperior.hruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient //Tornando um cliente eureka
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;	// pegando o BCryptPasswordEncoder que criei como bean

	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("BCrypt = " + passwordEncoder.encode("123456")); // gerando enconder para a senha não ficar explicita
	}

}
