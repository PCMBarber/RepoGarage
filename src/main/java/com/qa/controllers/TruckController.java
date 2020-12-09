package com.qa.controllers;

import java.util.List;

import com.qa.dao.TruckDAO;
import com.qa.utils.UserInput;
import com.qa.vehicles.Car;
import com.qa.vehicles.Truck;

public class TruckController implements GarageController<Truck> {
	
	private TruckDAO truckDAO;
	private UserInput input = UserInput.getInstance();
	
	public TruckController(TruckDAO truckDAO) {
		super();
		this.truckDAO = truckDAO;
	}

	@Override
	public Truck create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Truck> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Truck update() {
		// TODO Auto-generated method stub
		return null;
	}
}
