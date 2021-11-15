package com.qa.controllers;

import java.util.List;

import com.qa.dao.TruckDAO;
import com.qa.utils.UserInput;
import com.qa.vehicles.Car;
import com.qa.vehicles.Truck;

public class TruckController implements GarageController<Truck> {
	
	private TruckDAO truckDAO;
	private UserInput input;
	
	public TruckController(TruckDAO truckDAO) {
		super();
		this.input = UserInput.getInstance();
		this.truckDAO = truckDAO;
	}
	
	public TruckController(TruckDAO truckDAO, UserInput input) {
		super();
		this.input = input;
		this.truckDAO = truckDAO;
	}

	public Truck create() {
		int wheels, capacity;
		String colour;
		
		System.out.println("How many wheels does the truck have?");
		wheels = input.getInt();
		System.out.println("What colour is it?");
		colour = input.getString();
		System.out.println("Capacity? Kg");
		capacity = input.getInt();
		Truck newTruck = new Truck(wheels, colour, capacity);
		return truckDAO.create(newTruck);
	}

	public boolean delete() {
		readAll();
		System.out.println("ID of the truck you wish to delete?");
		int id = input.getInt();
		return truckDAO.delete(id);
	}

	public List<Truck> readAll() {
		List<Truck> all = truckDAO.readAll();
		for(Truck truck:all) {
			System.out.println(truck);
		}
		return all;
	}

	public Truck update() {
		readAll();
		
		System.out.println("ID of the truck you wish to Update?");
		int id = input.getInt();
		Truck myTruck = truckDAO.read(id);
		System.out.println("How many wheels does the truck have?");
		myTruck.setWheels(input.getInt());
		System.out.println("What colour is it?");
		myTruck.setColour(input.getString());
		System.out.println("Capacity? Kg");
		myTruck.setCapacity(input.getInt());
		
		if(truckDAO.delete(id)) {
			return truckDAO.create(myTruck);
		} else {
			System.out.println("Failed");
			return null;
		}
	}
}
