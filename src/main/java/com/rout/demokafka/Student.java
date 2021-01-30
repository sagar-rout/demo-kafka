package com.rout.demokafka;

/**
 * @author Sagar Rout
 *
 * Model class we are sending in the topic
 */
public class Student {

	private String firstName;
	private String lastName;
	private int age;

	public Student(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public int getAge() {
		return this.age;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
}
