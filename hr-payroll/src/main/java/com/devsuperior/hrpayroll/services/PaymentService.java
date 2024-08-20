package com.devsuperior.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long workerId, Integer days) {
		Payment payment = new Payment();
		payment.setName("Bob");
		payment.setDailyIncome(200.0);
		payment.setDays(days);
		return payment;
	}
}
