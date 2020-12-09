package com.qa.vehicles;

public class Truck extends Vehicle{
	
	private int capacity;
	
	public Truck(int wheels, String colour, int capacity) {
		super(wheels, colour);
		this.setCapacity(capacity);
		this.type = "Truck";
	}

	@Override
	public double calculateCost() {
		return 500;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
