package com.sms.ui;

import java.util.Scanner;

import com.sms.model.Student;
import com.sms.service.StudentManager;

public class StudentUserInterface {

	private final StudentManager manager = new StudentManager();
	private final Scanner scanner = new Scanner(System.in);

	public void displayUserInterface() {

		while (true) {
			System.out.println(
					"Please Select\n1.Add student\n2.Remove Student\n3.Update Studnet\n4.View Student\n5.Exit");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				removeStudent();
				break;
			case 3:
				updatestudent();
				break;
			case 4:
				displayStudent();
				break;
			case 5:
				System.out.println("Exited");
				return;

			default:
				System.out.println("invalid");
				return;
			}

		}

	}

	private void displayStudent() {

		manager.displayStudents();
	}

	private void updatestudent() {
		System.out.println("please enter student information you want to update");

		System.out.println("Enter Roll Number");
		int rollNumber = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter Name");
		String name = scanner.nextLine();

		System.out.println("Enter Age");
		int age = scanner.nextInt();

		manager.updateStudent(rollNumber, name, age);
	}

	private void removeStudent() {
		System.out.println("Enter Roll Number you want to delete");
		int rollNumber = scanner.nextInt();
		manager.removeStudent(rollNumber);
	}

	private void addStudent() {
		System.out.println("Enter Roll Number");
		int rollNumber = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter Name");
		String name = scanner.nextLine();

		System.out.println("Enter Age");
		int age = scanner.nextInt();

		Student student = new Student(rollNumber, name, age);
		manager.addStudent(student);
	}

}
