package com.qa.menu;

import com.qa.controllers.CarController;
import com.qa.controllers.GarageController;
import com.qa.utils.UserInput;

public class Menu {
	
	UserInput input = new UserInput();
	
	GarageController<?> active;
	CarController carController;
	
	public Menu() {
		//initialise controllers and DAO's
		carController = new CarController();
	}
	
	public void start() {
		System.out.println("(1) for Car");
		System.out.println("(2) for Truck");
		
		int selection = input.getInt();
		
		switch(selection) {
		case 1: active = carController;
				action();
				break;
		case 2:
		default:
		}
	}
	
	public void action() {
		System.out.println("what do you want to do?");
		int selection = input.getInt();
		
		switch(selection) {
		case 1: active.create();
		case 2: active.delete();
		case 3: active.read();
		case 4: active.readAll();
		}
	}

}
