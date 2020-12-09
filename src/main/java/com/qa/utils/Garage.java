package com.qa.utils;

import java.util.ArrayList;

import com.qa.vehicles.Vehicle;

public class Garage<T extends Vehicle> {
	
	private static Garage<?> instance = null;
	
	private Garage() {
		
	}
	
	public static Garage<?> getInstance() {
		if(instance == null) {
			instance = new Garage();
		}
		return instance;
	}
	
	private ArrayList<T> garage = new ArrayList<T>();

	public ArrayList<T> getGarage() {
		return garage;
	}
	
	public void clearGarage() {
		garage.clear();
	}

	public void insertGarage(T vehicle) {
		garage.add(vehicle);
	}
	
	public void removeByType(String type) {
		garage.removeIf(vehicle -> vehicle.getType().equals(type));
	}
	
	public void removeType(String type) {
		for(int i = garage.size()-1; i>= 0; i--) {
			if(garage.get(i).getType().equals(type)) {
				garage.remove(i);
			}
		}
	}
	
	public void removeByID(int id) {
		garage.removeIf(vehicle -> vehicle.getId() == id);
	}
	
	public ArrayList<T> searchGarage(String type) {
		ArrayList<T> found = new ArrayList<T>();
		for(T vehicle: garage) {
			if(vehicle.getType().equals(type)) {
				found.add(vehicle);
			}
		}
		return found;
	}
}

