package com.qa.controllers;

import java.util.List;

import com.qa.vehicles.Vehicle;

public interface GarageController<T extends Vehicle> {
	
	T create();
	
	boolean delete();
	
	T read();
	
	List<T> readAll();
	
	T update();
}
