package com.sms.service;

import java.util.ArrayList;
import java.util.List;

import com.sms.model.Student;

public class StudentManager {

	private final List<Student> students = new ArrayList<>();

	public void addStudent(Student s) {
		students.add(s);
		System.out.println("Student Added Sucessfully");
	}

	public void removeStudent(int rollNumber) {

		Student student = findStudentByRollNumber(rollNumber);
		students.remove(student);
		System.out.println("Student Removed Sucessfully");

	}

	public void updateStudent(int rollNumber, String newName, int newAge) {
		Student student = findStudentByRollNumber(rollNumber);

		student.setRollNumber(rollNumber);
		student.setName(newName);
		student.setAge(newAge);

		System.out.println("student is updated sucessfully");
	}

	public void displayStudents() {

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private Student findStudentByRollNumber(int rollNumber) {

		for (Student student : students)
			if (student.getRollNumber() == rollNumber) {
				return student;
			}
		return null;
	}

//	public static void main(String[] args) {
//		 StudentManager s=new  StudentManager();
//	    Student st = new Student(11,"pratik",22);
//	    Student st1 = new Student(12,"pratik",22);
//	     s.addStudent(st);
//	     s.addStudent(st1);
//	    
//	     s.displayStudents();
//	     s.displayStudents();
//		
//	}
}
