package com.qa.vehicles;

public abstract class Vehicle {

	private int id;
	private int wheels;
	private String colour;
	private static int count = 0;
	protected String type;

	public Vehicle(int wheels, String colour) {
		id = ++count;
		this.wheels = wheels;
		this.colour = colour;
	}
	
	public abstract double calculateCost();

	public static void setCount(int count) {
		Vehicle.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "id=" + id + ", wheels=" + wheels + ", colour=" + colour + ", type=" + type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (wheels != other.wheels)
			return false;
		return true;
	}
}
