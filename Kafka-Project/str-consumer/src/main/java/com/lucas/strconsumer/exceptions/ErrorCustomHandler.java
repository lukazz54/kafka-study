package com.lucas.strconsumer.exceptions;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		log.info("Exception_handler ::: Error Capturado");
		log.info("Payload ", message.getPayload()); // -> Payload = valor da mensagem enviada
		log.info("Header ", message.getHeaders().get("kafka_offset")); //-> Pegar valor do que esta dentro do header
		log.info("Message Exception ", exception.getMessage()); // -> mensagem da exceção
		
		return null;
		
	}

}
