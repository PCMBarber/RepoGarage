package com.qa.dao;

import java.util.List;

import com.qa.vehicles.Vehicle;

public interface Dao<T extends Vehicle> {
	
	T modelFromVehicle(T vehicle);
	
	T create(T vehicle);
	
	T read(int id);
	
	List<T> readAll();
	
	boolean delete(int id);
}
