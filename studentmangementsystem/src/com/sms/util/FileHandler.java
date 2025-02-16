package com.sms.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sms.constants.Constants;
import com.sms.model.Student;

public class FileHandler {

	public static void saveStudentsToFile(List<Student> students) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.STUDENT_FILE_PATH))) {
			for (Student student : students) {
				writer.write(student.getRollNumber() + "," + student.getName() + "," + student.getAge());
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println(Constants.ERROR_LOADING_DATA);
		}
	}

	public static List<Student> loadStudentsFromFile() {

		List<Student> students = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(Constants.STUDENT_FILE_PATH))) {
			File file = new File(Constants.STUDENT_FILE_PATH);
			if (!file.exists())
				return students;

			String line;

			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");

				if (data.length == 3) {
					int rollNumber = Integer.parseInt(data[0]);
					String name = data[1];
					int age = Integer.parseInt(data[2]);
					students.add(new Student(rollNumber, name, age));
				}

			}

		} catch (IOException | NumberFormatException e) {
			System.out.println(Constants.ERROR_SAVING_DATA + ": " + e.getMessage());
		}
		return students;
	}

	public static void main(String[] args) {
		loadStudentsFromFile();
	}

}
