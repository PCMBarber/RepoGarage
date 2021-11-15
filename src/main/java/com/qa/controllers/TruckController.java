package com.qa.controllers;

import java.util.List;

import com.qa.dao.TruckDAO;
import com.qa.utils.UserInput;
import com.qa.vehicles.Car;
import com.qa.vehicles.Truck;

public class TruckController implements GarageController<Truck> {
	
	private TruckDAO truckDAO;
	private UserInput input;
	
	public TruckController(TruckDAO truckDAO) {
		super();
		this.input = UserInput.getInstance();
		this.truckDAO = truckDAO;
	}
	
	public TruckController(TruckDAO truckDAO, UserInput input) {
		super();
		this.input = input;
		this.truckDAO = truckDAO;
	}

	public Truck create() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Truck> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Truck update() {
		// TODO Auto-generated method stub
		return null;
	}
}
