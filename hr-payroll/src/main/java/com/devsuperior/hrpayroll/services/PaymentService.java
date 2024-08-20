package com.devsuperior.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feingnclients.WorkerFeingnClient;

@Service
public class PaymentService {
	
	//Implementação do inteface WorkerFeingnClient
	@Autowired
	private WorkerFeingnClient workerFeingnClient;
	
	public Payment getPayment(Long workerId, Integer days) {
		
		
		Worker worker = workerFeingnClient.findById(workerId).getBody(); //pegando o corpo da requisição que vai vim do hr-worker
		
		Payment payment = new Payment();
		payment.setName(worker.getName());
		payment.setDailyIncome(worker.getDailyIncome());
		payment.setDays(days);
		return payment;
	}
}
