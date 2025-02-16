package com.sms.enums;

public enum MenuOption {
	ADD_STUDENT(1), REMOVE_STUDENT(2), UPDATE_STUDENT(3), VIEW_STUDENTS(4), EXIT(5);

	private final int value;

	MenuOption(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static MenuOption fromValue(int value) {
		for (MenuOption option : values()) {
			if (option.value == value) {
				return option;
			}
		}
		return null;
	}
}
