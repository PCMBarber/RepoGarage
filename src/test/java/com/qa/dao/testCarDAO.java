package com.qa.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.utils.Garage;
import com.qa.vehicles.Car;
import com.qa.vehicles.Vehicle;

@RunWith(MockitoJUnitRunner.class)
public class testCarDAO {

	@Mock
	Garage garage;

	@InjectMocks
	CarDAO carDAO;

	@Before
	public void reset() {
		Vehicle.setCount(0);
	}

	@Test
	public void testCreate() {
		Car testCar = new Car(4, "test", "test", 250);

		when(garage.getSize()).thenReturn(0, 1);

		assertEquals(testCar, carDAO.create(testCar));

		verify(garage, times(2)).getSize();
		verify(garage, times(1)).insertGarage(testCar);
	}

	@Test
	public void testCreateFail() {
		Car testCar = new Car(4, "test", "test", 250);

		when(garage.getSize()).thenReturn(0, 0);

		assertNull(carDAO.create(testCar));

		verify(garage, times(2)).getSize();
		verify(garage, times(1)).insertGarage(testCar);
	}

	@Test
	public void testRead() {
		Car testCar = new Car(4, "test", "test", 250);
		Vehicle testVehicle = testCar;
		int id = 1;

		when(garage.findByID(id)).thenReturn(testVehicle);

		assertEquals(testCar, carDAO.read(id));

		verify(garage, times(1)).findByID(id);
	}

	@Test
	public void testReadAll() {
		Car testCar = new Car(4, "test", "test", 250);
		Car testCar2 = new Car(4, "test2", "test2", 250);
		ArrayList<Vehicle> testListVehicle = new ArrayList<Vehicle>();
		List<Car> testListCar = new ArrayList<Car>();

		testListVehicle.add(testCar);
		testListVehicle.add(testCar2);
		testListCar.add(testCar);
		testListCar.add(testCar2);

		when(garage.searchByType("Car")).thenReturn(testListVehicle);

		assertEquals(testListCar, carDAO.readAll());

		verify(garage, times(1)).searchByType("Car");
	}

	@Test
	public void testDelete() {
		int id = 1;

		when(garage.getSize()).thenReturn(0, 1);

		assertEquals(true, carDAO.delete(id));

		verify(garage, times(2)).getSize();
		verify(garage, times(1)).removeByID(id);
	}

	@Test
	public void testDeleteFail() {
		int id = 1;

		when(garage.getSize()).thenReturn(0, 0);

		assertEquals(false, carDAO.delete(id));

		verify(garage, times(2)).getSize();
		verify(garage, times(1)).removeByID(id);
	}
}
