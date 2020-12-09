package com.qa.vehicles;

public class Car extends Vehicle {
	
	private String maker;
	private int horsePower;
	
	public Car(int wheels, String colour, String maker, int horsePower) {
		super(wheels, colour);
		this.maker = maker;
		this.horsePower = horsePower;
		this.type = "Car";
	}

	@Override
	public double calculateCost() {
		return 250;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	
}
