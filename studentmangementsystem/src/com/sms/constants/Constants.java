package com.sms.constants;

import java.io.File;
import java.nio.file.Paths;

public class Constants {

	public static final String STUDENT_FILE_PATH = Constants.class.getClassLoader().getResource("resources/student.txt")
			.getPath();

	public static final String ERROR_SAVING_DATA = "Error saving student data!";
	public static final String ERROR_LOADING_DATA = "Error loading student data: ";
    public static final String STUDENT_EXISTS = "Roll Number %d already exists.";
    public static final String STUDENT_NOT_FOUND = "Student with Roll Number %d not found.";
    public static final String NO_STUDENTS_FOUND = "No students available in the system.";
    public static final String STUDENT_ADDED = "Student Added Successfully";
    public static final String STUDENT_REMOVED = "Student Removed Successfully";
    public static final String STUDENT_UPDATED = "Student is updated successfully";

}
