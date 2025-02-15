package com.sms.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.sms.exceptions.InvalidStudentDataException;
import com.sms.exceptions.NoStudentsFoundException;
import com.sms.model.Student;

public class StudentManager {

	private final List<Student> students = new ArrayList<>();

	public void addStudent(Student student) {
		if (findStudentByRollNumber(student.getRollNumber()) != null) {
			throw new InvalidStudentDataException("Roll Number " + student.getRollNumber() + " already exists.");
		}
		students.add(student);
		System.out.println("Student Added Sucessfully");
	}

	public void removeStudent(int rollNumber) {

		Student student = findStudentByRollNumber(rollNumber);
		if (student == null) {
			throw new InvalidStudentDataException("Student with Roll Number " + rollNumber + " not found.");
		}
		students.remove(student);
		System.out.println("Student Removed Sucessfully");

	}

	public void updateStudent(int rollNumber, String newName, int newAge) {
		Student student = findStudentByRollNumber(rollNumber);
		if (student == null) {
			throw new InvalidStudentDataException("Student with Roll Number " + rollNumber + " not found.");
		}
		student.setRollNumber(rollNumber);
		student.setName(newName);
		student.setAge(newAge);

		System.out.println("student is updated sucessfully");
	}

	public void displayStudents() {

		if (students.isEmpty()) {
			 throw new NoStudentsFoundException("No students available in the system.");
		}
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

}
