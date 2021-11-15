package com.qa.dao;

import java.util.List;

import com.qa.utils.Garage;
import com.qa.vehicles.Truck;
import com.qa.vehicles.Vehicle;

public class TruckDAO implements Dao<Truck> {
	
	private Garage garage;
	
	public TruckDAO() {
		this.garage = Garage.getInstance();
	}
	
	public TruckDAO(Garage garage) {
		this.garage = garage;
	}
	
	public Truck modelFromVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	public Truck create(Truck vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	public Truck read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Truck> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
