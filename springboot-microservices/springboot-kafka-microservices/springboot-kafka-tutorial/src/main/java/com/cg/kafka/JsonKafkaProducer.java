package com.cg.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.cg.User;

@Service
public class JsonKafkaProducer {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

	    //private NewTopic topic;
	 @Value("${spring.kafka.topic-json.name}")
	 private String topicJsonName;

	    private KafkaTemplate<String, User> kafkaTemplate;

	    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
	        this.kafkaTemplate = kafkaTemplate;
	    }

	    public void sendMessage(User event){
	        LOGGER.info(String.format("Json message sent => %s", event.toString()));

	        // create Message
	        Message<User> message = MessageBuilder
	                .withPayload(event)
	                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
	                .build();
	        kafkaTemplate.send(message);
	    }
}
