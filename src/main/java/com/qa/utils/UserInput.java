package com.qa.utils;

import java.util.Scanner;

public class UserInput {
	private static Scanner scan = new Scanner(System.in);

	public String getString() {
		return scan.nextLine();
	}

	public int getInt() {
		int value;
		while (true) {
			try {
				System.out.println("Please type an Int");
				value = Integer.parseInt(scan.nextLine());
				return value;
			} catch (NumberFormatException exception) {
				exception.printStackTrace();
			}
		}
	}
}
