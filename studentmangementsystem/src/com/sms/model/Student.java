package com.sms.model;

public class Student {

	private int rollNumber;
	private String name;
	private int age;

	public Student(int rollNumber, String name, int age) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.age = age;
	}

	public int getRollNumber() {
		return this.rollNumber;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return age;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student { " + "rollNumber=" + rollNumber + ", Name='" + name + '\'' + ", Age=" + age + " }";
	}
}
