package com.lucas.paymentservice.resource.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.paymentservice.model.Payment;
import com.lucas.paymentservice.resource.PaymentResource;
import com.lucas.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {

	private final PaymentService paymentService;
	
	@Override
	public ResponseEntity<Payment> payment(Payment payment) {
		paymentService.sendPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
