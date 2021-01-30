/**
 * 
 */
package com.rout.demokafka;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sagar Rout
 *
 */
@RestController
public class StudentController {

	private final StudentProducer producer;
	
	public StudentController(StudentProducer producer) {
		this.producer = producer;
	}
	
	@PostMapping(value="/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Student student) throws Exception{
		producer.sendMessage(student);
	}
}
