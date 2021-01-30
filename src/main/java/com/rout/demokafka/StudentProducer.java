/**
 * 
 */
package com.rout.demokafka;

import java.util.Date;
import java.util.logging.Logger;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Sagar Rout
 */
@Component
public class StudentProducer {

	private static final Logger LOGGER = Logger.getLogger("Producer");
	public static final String TOPIC_NAME = "students";

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper objectMapper;

	public StudentProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
	}

	public void sendMessage(Student student)throws Exception {
		LOGGER.info(String.format("Send student information as an event @ %s", new Date()));
		
		kafkaTemplate.send(TOPIC_NAME, "student", objectMapper.writeValueAsString(student));
	}
}
