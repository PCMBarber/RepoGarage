package com.qa.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.dao.CarDAO;
import com.qa.utils.UserInput;
import com.qa.vehicles.Car;

@RunWith(MockitoJUnitRunner.class)
public class TestCarController {
	
	@Mock
	private CarDAO carDAO;
	
	@Mock
	private UserInput input;
	
	@InjectMocks
	private CarController carController;
	//private doesn't really make a difference in tests
	//just good practice init
	
	@Test
	public void testCreate() {
		int wheels = 4;
		String colour = "Blue";
		String maker = "BMW";
		int horsePower = 270;
		Car expected = new Car(wheels, colour, maker, horsePower);
		// First Car creates with ID of 1
		expected.setId(2); 
		// Expected has to change ID to match output from controller
		when(input.getInt()).thenReturn(wheels, horsePower);
		when(input.getString()).thenReturn(colour, maker);
		when(carDAO.create(expected)).thenReturn(expected);
		
		assertEquals(expected, carController.create());
		// Car controller makes the 2nd Vehicle with ID 2
		verify(input, times(2)).getInt();
		verify(input, times(2)).getString();
		verify(carDAO, times(1)).create(expected);
	}
	
	@Test
	public void testDelete() {
		List<Car> allCars = new ArrayList<Car>();
		Car mockCar1 = mock(Car.class);
		Car mockCar2 = mock(Car.class);
		allCars.add(mockCar1);
		allCars.add(mockCar2);
		
		when(mockCar1.toString()).thenReturn("Mock Car");
		when(mockCar2.toString()).thenReturn("Mock Car");
		when(carDAO.readAll()).thenReturn(allCars);
		when(carDAO.delete(1)).thenReturn(true);
		when(input.getInt()).thenReturn(1);
		
		assertTrue(carController.delete());
		
		verify(carDAO, times(1)).readAll();
		verify(carDAO, times(1)).delete(1);
		verify(input, times(1)).getInt();
	}
	
	@Test
	public void testReadAll() {
		List<Car> allCars = new ArrayList<Car>();
		Car mockCar1 = mock(Car.class);
		Car mockCar2 = mock(Car.class);
		allCars.add(mockCar1);
		allCars.add(mockCar2);
		
		when(mockCar1.toString()).thenReturn("Mock Car");
		when(mockCar2.toString()).thenReturn("Mock Car");
		when(carDAO.readAll()).thenReturn(allCars);
		
		assertEquals(allCars,carController.readAll());
		
		verify(carDAO, times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {
		List<Car> allCars = new ArrayList<Car>();
		Car mockCar1 = mock(Car.class);
		Car mockCar2 = mock(Car.class);
		Car oldCar = new Car(4,"Red","BMW",250);
		oldCar.setId(1);
		allCars.add(mockCar1);
		allCars.add(mockCar2);
		
		int id = 1;
		int wheels = 4;
		String colour = "Blue";
		String maker = "BMW";
		int horsePower = 270;
		Car newCar = new Car(wheels,colour,maker,horsePower);
		newCar.setId(id);
		
		when(carDAO.read(id)).thenReturn(oldCar);
		when(carDAO.delete(id)).thenReturn(true);
		when(carDAO.create(newCar)).thenReturn(newCar);
		when(mockCar1.toString()).thenReturn("Mock Car");
		when(mockCar2.toString()).thenReturn("Mock Car");
		when(carDAO.readAll()).thenReturn(allCars);
		when(input.getInt()).thenReturn(id, wheels, horsePower);
		when(input.getString()).thenReturn(colour, maker);
		
		assertEquals(newCar, carController.update());
		
		verify(carDAO, times(1)).readAll();
		verify(carDAO, times(1)).read(id);
		verify(carDAO, times(1)).delete(id);
		verify(carDAO, times(1)).create(newCar);
		verify(input, times(3)).getInt();
		verify(input, times(2)).getString();
	}
	
	@After
	public void cleanUp() {
		Car.setCount(0);
	}
}
