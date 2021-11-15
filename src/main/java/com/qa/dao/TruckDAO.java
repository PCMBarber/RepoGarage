package com.qa.dao;

import java.util.ArrayList;
import java.util.List;

import com.qa.utils.Garage;
import com.qa.vehicles.Car;
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
		return (Truck) vehicle;
	}

	public Truck create(Truck vehicle) {
		int before = garage.getSize();
		garage.insertGarage(vehicle);
		int after = garage.getSize();
		if(before == after) {
			System.out.println("Failed");
			return null;
		}
		return vehicle;
	}

	public Truck read(int id) {
		return modelFromVehicle(garage.findByID(id));
	}

	public List<Truck> readAll() {
		List<Vehicle> found = garage.searchByType("Truck");
		List<Truck> trucks = new ArrayList<Truck>();
		for(Vehicle v:found) {
			trucks.add(modelFromVehicle(v));
		}
		return trucks;
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
