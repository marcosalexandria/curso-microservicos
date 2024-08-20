package com.devsuperior.hrpayroll.feingnclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsuperior.hrpayroll.entities.Worker;

@Component	//Componente gerenciado pelo spring, possivel injetar em outras classes
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeingnClient {
	
	//A mesma assinatura do método na classe de WorkerResourcer no projeto hr-worker
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id);
}
