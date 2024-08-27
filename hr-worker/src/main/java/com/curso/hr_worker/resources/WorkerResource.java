package com.curso.hr_worker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.hr_worker.entity.Worker;
import com.curso.hr_worker.repositories.WorkerRepository;

@RefreshScope //Essa anotacao eh para toda classe que acessa configuracao
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment env; //estudar esse objeto, tem muitas informações do contexto da aplicação dentro dele
	
	@Autowired
	private WorkerRepository repository;
	
	@Value("${test.config}") //Atribuido as configuracoes de test.config que esta no arquiquivo do github
	private String testConfig;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		logger.info("PORT = " + env.getProperty("local.server.port"));	//mostrando a porta no console
		
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs(){
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}

}
