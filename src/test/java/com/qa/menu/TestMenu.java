package com.qa.menu;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.controllers.CarController;
import com.qa.controllers.TruckController;
import com.qa.utils.UserInput;

@RunWith(MockitoJUnitRunner.class)
public class TestMenu {
	
	@Mock
	CarController carController;
	
	@Mock
	TruckController truckController;
	
	@Mock
	UserInput input;
	
	@InjectMocks
	Menu menu;
	
	
	@Test
	public void testStartCreate() {
		// Given
		when(input.getInt()).thenReturn(1, 1, 5, 3);
		
		// When
		menu.start();
		
		// Then
		verify(input, Mockito.times(4)).getInt();
		verify(carController, times(1)).create();
	}
	
	@Test
	public void testStartDelete() {
		// Given
		when(input.getInt()).thenReturn(2, 2, 5, 3);
		
		// When
		menu.start();
		
		// Then
		verify(input, times(4)).getInt();
		verify(truckController, times(1)).delete();
	}
	
	@Test
	public void testStartReadAll() {
		// Given
		when(input.getInt()).thenReturn(1, 3, 5, 3);
		
		// When
		menu.start();
		
		// Then
		verify(input, Mockito.times(4)).getInt();
		verify(carController, times(1)).readAll();
	}
	
	@Test
	public void testStartUpdate() {
		// Given
		when(input.getInt()).thenReturn(2, 4, 5, 3);
		
		// When
		menu.start();
		
		// Then
		verify(input, times(4)).getInt();
		verify(truckController, times(1)).update();
	}
	
}
