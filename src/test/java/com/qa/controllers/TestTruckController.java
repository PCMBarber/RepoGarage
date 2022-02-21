package com.qa.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.dao.TruckDAO;
import com.qa.utils.UserInput;
import com.qa.vehicles.Truck;

@RunWith(MockitoJUnitRunner.class)
public class TestTruckController {
	
	@Mock
	private TruckDAO truckDAO;
	
	@Mock
	private UserInput input;
	
	@InjectMocks
	private TruckController truckController;
	
	@Test
	public void testCreate() {
		int wheels = 4;
		String colour = "Blue";
		int capacity = 270;
		Truck expected = new Truck(wheels, colour, capacity);
		expected.setId(2); 
		// Expected has to change ID to match output from controller
		when(input.getInt()).thenReturn(wheels, capacity);
		when(input.getString()).thenReturn(colour);
		when(truckDAO.create(expected)).thenReturn(expected);
		
		assertEquals(expected, truckController.create());
		// Car controller makes the 2nd Vehicle with ID 2
		verify(input, times(2)).getInt();
		verify(input, times(1)).getString();
		verify(truckDAO, times(1)).create(expected);
	}
}
