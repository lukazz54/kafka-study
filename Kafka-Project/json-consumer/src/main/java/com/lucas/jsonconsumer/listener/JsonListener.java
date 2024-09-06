package com.lucas.jsonconsumer.listener;

import static java.lang.Thread.sleep;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.lucas.paymentservice.model.Payment;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JsonListener {
	
	@SneakyThrows
	@KafkaListener(topics="payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
	public void antiFraude(@Payload Payment payment) {
		
		log.info("Recebi o pagament {}", payment.toString());
		sleep(2000);
		log.info("Validando fraude");
		
		sleep(2000);
		log.info("Compra aprovada");
	}
	
	@SneakyThrows
	@KafkaListener(topics="payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
	public void pdfGenerator(@Payload Payment payment) {
		log.info("Gerando PDF do produto de id {}, " ,payment.getIdProduct());
		log.info("Gerando PDF");
		sleep(2000);
		
	}
	
	@SneakyThrows
	@KafkaListener(topics="payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
	public void sendEmail() {
		log.info("Enviando email de confirmação");
	}
	
}
