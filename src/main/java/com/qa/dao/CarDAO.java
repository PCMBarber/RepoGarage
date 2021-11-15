package com.qa.dao;

import java.util.ArrayList;
import java.util.List;

import com.qa.utils.Garage;
import com.qa.vehicles.Car;
import com.qa.vehicles.Vehicle;

public class CarDAO implements Dao<Car> {
	
	private Garage garage;
	
	public CarDAO() {
		this.garage = Garage.getInstance();
	}
	
	public CarDAO(Garage garage) {
		this.garage = garage;
	}

	public Car modelFromVehicle(Vehicle vehicle) {
		return (Car) vehicle;
	}

	public Car create(Car vehicle) {
		int before = garage.getSize();
		garage.insertGarage(vehicle);
		int after = garage.getSize();
		if(before == after) {
			System.out.println("Failed");
			return null;
		}
		return vehicle;
	}

	public Car read(int id) {
		return modelFromVehicle(garage.findByID(id));
	}

	public List<Car> readAll() {
		List<Vehicle> found = garage.searchByType("Car");
		List<Car> cars = new ArrayList<Car>();
		for(Vehicle v:found) {
			cars.add(modelFromVehicle(v));
		}
		return cars;
	}

	public boolean delete(int id) {
		int before = garage.getSize();
		garage.removeByID(id);
		int after = garage.getSize();
		if(before == after) {
			System.out.println("Failed");
			return false;
		}
		return true;
	}
	

}
