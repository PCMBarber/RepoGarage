package com.qa.menu;

import com.qa.controllers.CarController;
import com.qa.controllers.GarageController;
import com.qa.controllers.TruckController;
import com.qa.dao.CarDAO;
import com.qa.dao.TruckDAO;
import com.qa.utils.UserInput;

public class Menu {

	UserInput input;

	GarageController<?> active;
	CarController carController;
	TruckController truckController;

	public Menu(UserInput input, CarController carController,
			TruckController truckController) {
		super();
		this.input = input;
		this.carController = carController;
		this.truckController = truckController;
	}

	public Menu() {
		CarDAO carDAO = new CarDAO();
		TruckDAO truckDAO = new TruckDAO();
		carController = new CarController(carDAO);
		truckController = new TruckController(truckDAO);
		input = UserInput.getInstance();
	}

	public void start() {
		boolean exit = false;
		do {
			System.out.println("1) Car");
			System.out.println("2) Truck");
			System.out.println("3) Exit");

			int selection = input.getInt();

			switch (selection) {
			case 1:
				active = carController;
				action();
				break;
			case 2:
				active = truckController;
				System.out.println("Unimplemented");
				action();
				break;
			case 3:
				exit = true;
			}
		} while (!exit);
	}

	public void action() {
		boolean back = false;
		do {
			System.out.println("what do you want to do?");
			System.out.println("1) Create");
			System.out.println("2) Delete");
			System.out.println("3) Read All");
			System.out.println("4) Update");
			System.out.println("5) Return");
			
			int selection = input.getInt();

			switch (selection) {
			case 1:
				active.create();
				break;
			case 2:
				active.delete();
				break;
			case 3:
				active.readAll();
				break;
			case 4:
				active.update();
				break;
			case 5:
				back = true;
			}
		} while (!back);
	}

}
