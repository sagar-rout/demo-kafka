/**
 * 
 */
package com.rout.demokafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Sagar Rout
 */
@Component
public class StudentConsumer {

	private final ObjectMapper objectMapper;

	public StudentConsumer(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@KafkaListener(topics = StudentProducer.TOPIC_NAME, groupId = "group-id")
	public void consumer(String message) throws Exception {
		Student student = objectMapper.readValue(message, Student.class);
		
		System.out.println(student.toString());
	}
}
