package com.qa.controllers;

import java.util.List;

import com.qa.dao.CarDAO;
import com.qa.utils.UserInput;
import com.qa.vehicles.Car;

public class CarController implements GarageController<Car> {
	
	private CarDAO carDAO;
	private UserInput input = UserInput.getInstance();
	
	public CarController(CarDAO carDAO) {
		super();
		this.carDAO = carDAO;
	}
	
	@Override
	public Car create() {
		System.out.println("How many wheels does the car have?");
		int wheels = input.getInt();
		System.out.println("What colour is it?");
		String colour = input.getString();
		System.out.println("Manufacturer?");
		String maker = input.getString();
		System.out.println("How many horsepower?");
		int horsePower = input.getInt();
		
		Car newCar = new Car(wheels, colour, maker, horsePower);
		return carDAO.create(newCar);
	}

	@Override
	public boolean delete() {
		readAll();
		System.out.println("ID of the car you wish to delete?");
		int id = input.getInt();
		return carDAO.delete(id);
	}

	@Override
	public List<Car> readAll() {
		List<Car> all = carDAO.readAll();
		for(Car car:all) {
			System.out.println(car);
		}
		return all;
	}

	@Override
	public Car update() {
		readAll();
		
		System.out.println("ID of the car you wish to Update?");
		int id = input.getInt();
		Car myCar = carDAO.read(id);
		System.out.println("How many wheels does the car have?");
		myCar.setWheels(input.getInt());
		System.out.println("What colour is it?");
		myCar.setColour(input.getString());
		System.out.println("Manufacturer?");
		myCar.setMaker(input.getString());
		System.out.println("How many horsepower?");
		myCar.setHorsePower(input.getInt());
		
		if(carDAO.delete(id)) {
			return carDAO.create(myCar);
		} else {
			System.out.println("Failed");
			return null;
		}
	}

}
