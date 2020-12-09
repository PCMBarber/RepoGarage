package com.qa.utils;

import java.util.ArrayList;

import com.qa.vehicles.Vehicle;

public class Garage {

	private static Garage instance = null;
	private ArrayList<Vehicle> garage = new ArrayList<Vehicle>();

	private Garage() {

	}

	public static Garage getInstance() {
		if (instance == null) {
			instance = new Garage();
		}
		return instance;
	}

	public ArrayList<Vehicle> getGarage() {
		return garage;
	}

	public void clearGarage() {
		garage.clear();
	}
	
	public int getSize() {
		return garage.size();
	}

	public void insertGarage(Vehicle vehicle) {
		garage.add(vehicle);
	}

	public void removeByType(String type) {
		garage.removeIf(vehicle -> vehicle.getType().equals(type));
	}

	public void removeType(String type) {
		for (int i = garage.size() - 1; i >= 0; i--) {
			if (garage.get(i).getType().equals(type)) {
				garage.remove(i);
			}
		}
	}

	public void removeByID(int id) {
		garage.removeIf(vehicle -> vehicle.getId() == id);
	}

	public Vehicle findByID(int id) {
		for (Vehicle v : garage) {
			if (v.getId() == id) {
				return v;
			}
		}
		return null;
	}

	public ArrayList<Vehicle> searchByType(String type) {
		ArrayList<Vehicle> found = new ArrayList<Vehicle>();
		for (Vehicle vehicle : garage) {
			if (vehicle.getType().equals(type)) {
				found.add(vehicle);
			}
		}
		return found;
	}
}
