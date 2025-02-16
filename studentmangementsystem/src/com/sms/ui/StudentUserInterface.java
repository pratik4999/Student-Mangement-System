package com.sms.ui;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.sms.enums.MenuOption;
import com.sms.exceptions.InvalidStudentDataException;
import com.sms.model.Student;
import com.sms.service.StudentManager;

public class StudentUserInterface {

	private final StudentManager manager = new StudentManager();
	private final Scanner scanner = new Scanner(System.in);

	public void displayUserInterface() {
		try {
			while (true) {
				System.out.println(
						"Please Select\n1.Add Student\n2.Remove Student\n3.Update Student\n4.View Students\n5.Exit");

				int choice = scanner.nextInt();
				MenuOption option = MenuOption.fromValue(choice);

				if (option == null) {
					System.out.println("Invalid choice. Please select a number between 1 and 5. Try again.");
					continue;
				}

				switch (option) {
				case ADD_STUDENT:
					addStudent();
					break;
				case REMOVE_STUDENT:
					removeStudent();
					break;
				case UPDATE_STUDENT:
					updateStudent();
					break;
				case VIEW_STUDENTS:
					displayStudents();
					break;
				case EXIT:
					System.out.println("Exited");
					scanner.close();
					return;
				}
			}
		} catch (InputMismatchException e) {
			scanner.nextLine();
			throw new InputMismatchException("Invalid input! Please enter a number between 1 and 5.");
		}
	}

	private void displayStudents() {
		manager.displayStudents();
	}

	private void updateStudent() {
		System.out.println("Enter Student Roll Number to Update:");
		int rollNumber = scanner.nextInt();
		if (rollNumber < 0) {
			throw new InvalidStudentDataException("Roll number cannot be negative.");
		}
		scanner.nextLine();

		System.out.println("Enter Name:");
		String name = scanner.nextLine();

		System.out.println("Enter Age:");
		int age = scanner.nextInt();
		if (age < 0) {
			throw new InvalidStudentDataException("Age cannot be negative.");
		}

		manager.updateStudent(rollNumber, name, age);
	}

	private void removeStudent() {
		System.out.println("Enter Roll Number you want to delete:");
		int rollNumber = scanner.nextInt();
		manager.removeStudent(rollNumber);
	}

	private void addStudent() {
		System.out.println("Enter Roll Number:");
		int rollNumber = scanner.nextInt();
		if (rollNumber < 0) {
			throw new InvalidStudentDataException("Roll number cannot be negative.");
		}
		scanner.nextLine();

		System.out.println("Enter Name:");
		String name = scanner.nextLine();

		System.out.println("Enter Age:");
		int age = scanner.nextInt();
		if (age < 0) {
			throw new InvalidStudentDataException("Age cannot be negative.");
		}

		Student student = new Student(rollNumber, name, age);
		manager.addStudent(student);
	}
}
