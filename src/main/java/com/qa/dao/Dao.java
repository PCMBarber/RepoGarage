package com.qa.dao;

import java.util.List;

import com.qa.vehicles.Vehicle;

public interface Dao<T extends Vehicle> {
	
	T modelFromVehicle(Vehicle vehicle);
	
	T create(T vehicle);
	
	T read(int id);
	
	List<T> readAll();
	
	boolean delete(int id);
}
