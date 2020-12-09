package com.qa.dao;

import java.util.List;

import com.qa.utils.Garage;
import com.qa.vehicles.Vehicle;

public class CarDAO implements Dao {
	
	Garage garage = new Garage();

	public Vehicle modelFromVehicle(Vehicle vehicle) {
		
	}

	public Vehicle create(Vehicle vehicle) {
		garage.insertGarage(vehicle);
		return vehicle;
	}

	public Vehicle read(int id) {
		// TODO Auto-generated method stub
		return null;
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
