package com.lucas.strconsumer.literners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.lucas.strconsumer.custom.StrConsumerCustomListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {
	
//	Quando temos varios listeners mesmo GROUPID, apontando para o MESMO Topico, o Kafka ele 
	//divide as partiçoes nesses listeners... entao e houver soh um esse sera assinado em todos as partições
	//caso tenha dois, cada um sera assinado em uma partição, E se tiver mais listeners do que partições
	//esse listener a mais, nao conseguirá se assinar em nenhuma partição
	
	@StrConsumerCustomListener(groupId = "group-1")
	public void create(String message) {
		log.info("Create ::: Receive message {} ", message);
	}
	
	@StrConsumerCustomListener(groupId = "group-1")
	public void log(String message) {
		log.info("Log ::: Receive message {} ", message);
	}
	
//	@StrConsumerCustomListener(groupId = "group-2")
	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
	public void history(String message) {
		log.info("History ::: Receive message {} ", message);
	}
}
