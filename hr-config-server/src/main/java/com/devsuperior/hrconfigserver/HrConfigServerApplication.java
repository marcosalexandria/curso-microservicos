package com.devsuperior.hrconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer	//Configurando como servidor de configuracao
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner{
	
	@Value("${spring.cloud.config.server.git.username}")
	private String nome;

	@Value("${spring.cloud.config.server.git.password}")
	private String senha;

	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("GITHUB_USER e GITHUB_PASS = " + nome + " " + senha);
		
	}

}
