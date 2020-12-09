package com.qa.dao;

import java.util.List;

import com.qa.utils.Garage;
import com.qa.vehicles.Vehicle;

public class CarDAO implements Dao {
	
	Garage<?> garage = Garage.getInstance();
	
	public Car modelFromVehicle(Vehicle vehicle) {
		return (Car) vehicle;
	}

	public Car create(Vehicle vehicle) {
		garage.insertGarage(vehicle);
		return ;
	}

	public Car read(int id) {
		Vehicle vehicle = garage.read(id);
		return modelFromVehicle(vehicle);
	}

	public List readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
