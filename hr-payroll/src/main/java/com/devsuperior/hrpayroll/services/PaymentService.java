package com.devsuperior.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	//atribuido para workerHost a variavel hr-worker.host do application.properties
	@Value("${hr-worker.host}")
	private String workerHost;
	
	//dependencia do RestTemplate que está instanciado no AppConfig.restTemplate
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(Long workerId, Integer days) {
		
		Map<String, String> uriVariables = new HashMap<>();
		
		uriVariables.put("id", workerId.toString());
		
		//criando uma resuisição com restTemplate entre 2 sistemas diferentes
		Worker worker = restTemplate.getForObject(
				workerHost + "/workers/{id}", //caminho do host com a variavel entre chaves
				Worker.class, 	//a classe que esperamos de retorno
				uriVariables);	//os parametros que vão ficar no lugar das variaveis que estão entre chaves
		
		Payment payment = new Payment();
		payment.setName(worker.getName());
		payment.setDailyIncome(worker.getDailyIncome());
		payment.setDays(days);
		return payment;
	}
}
