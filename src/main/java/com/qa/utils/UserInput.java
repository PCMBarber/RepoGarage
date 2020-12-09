package com.qa.utils;

import java.util.Scanner;

public class UserInput {
	
	private Scanner scan = new Scanner(System.in);
	private static UserInput instance = null;
	
	private UserInput() {
		
	}
	
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

	public static UserInput getInstance() {
		if(instance == null) {
			instance = new UserInput();
		}
		return instance;
	}
}
