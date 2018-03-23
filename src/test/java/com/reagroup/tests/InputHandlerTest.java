package com.reagroup.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.reagroup.toyrobot.InputHandler;
import com.reagroup.toyrobot.Position;
import com.reagroup.toyrobot.commands.*;
import com.reagroup.toyrobot.Direction;

public class InputHandlerTest
{
	private static InputHandler inputHandler;
	
	@BeforeClass
	public static void setUp()
	{
		inputHandler = new InputHandler();
	}
	
	@Test
	public void testPlaceCommandInput()
	{
		Command placeCommand = inputHandler.handleInput("PLACE 0 1 NORTH");
		assertEquals(new PlaceCommand(new Position(0, 1, Direction.NORTH)), placeCommand);
	}
	
	@Test
	public void testReportCommandInput()
	{
		Command reportCommand = inputHandler.handleInput("REPORT");
		assertEquals(new ReportCommand(System.out), reportCommand);
	}
	
	@Test
	public void testUnknownCommandInput()
	{
		Command expected = new UnknownCommand();
		
		Command unknownCommand = inputHandler.handleInput(" ");
		assertEquals(expected, unknownCommand);
		
		unknownCommand =  inputHandler.handleInput("PLACE");
		assertEquals(expected, unknownCommand);
		
		unknownCommand = inputHandler.handleInput("PLACE 2 3 NORTH SOUTH");
		assertEquals(expected, unknownCommand);
		
		unknownCommand = inputHandler.handleInput("PLACE 2 3 SOUTHWEST");
		assertEquals(expected, unknownCommand);
		
		unknownCommand = inputHandler.handleInput("PLACE A 3 NORTH");
		assertEquals(expected, unknownCommand);
	}
}
