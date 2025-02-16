package com.sms.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.sms.constants.Constants;
import com.sms.exceptions.InvalidStudentDataException;
import com.sms.exceptions.NoStudentsFoundException;
import com.sms.model.Student;
import com.sms.util.FileHandler;

public class StudentManager {

	private final List<Student> students = new ArrayList<>();

	public StudentManager() {
		students.addAll(FileHandler.loadStudentsFromFile());
	}

	public void addStudent(Student student) {
		if (findStudentByRollNumber(student.getRollNumber()) != null) {
			throw new InvalidStudentDataException(String.format(Constants.STUDENT_EXISTS, student.getRollNumber()));
		}
		students.add(student);
		FileHandler.saveStudentsToFile(students);
		System.out.println(Constants.STUDENT_ADDED);
	}

	public void removeStudent(int rollNumber) {

		Student student = findStudentByRollNumber(rollNumber);
		if (student == null) {
			throw new InvalidStudentDataException(String.format(Constants.STUDENT_NOT_FOUND, rollNumber));
		}
		students.remove(student);
		FileHandler.saveStudentsToFile(students);
		System.out.println(Constants.STUDENT_REMOVED);

	}

	public void updateStudent(int rollNumber, String newName, int newAge) {
		Student student = findStudentByRollNumber(rollNumber);
		if (student == null) {
			throw new InvalidStudentDataException(String.format(Constants.STUDENT_NOT_FOUND, rollNumber));
		}
		student.setRollNumber(rollNumber);
		student.setName(newName);
		student.setAge(newAge);
		FileHandler.saveStudentsToFile(students);
		System.out.println(Constants.STUDENT_UPDATED);
	}

	public void displayStudents() {

		if (students.isEmpty()) {
			throw new NoStudentsFoundException(Constants.NO_STUDENTS_FOUND);
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
