package com.reagroup.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.reagroup.toyrobot.controller.InputHandler;
import com.reagroup.toyrobot.controller.commands.*;
import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;

public class TestInputHandler
{
	
	@Test
	public void testPlaceCommandInput()
	{
		Command placeCommand = InputHandler.handleInput("PLACE 0 1 NORTH");
		assertEquals(new PlaceCommand(new Position(0, 1, Direction.NORTH)), placeCommand);
	}
	
	@Test
	public void testReportCommandInput()
	{
		Command reportCommand = InputHandler.handleInput("REPORT");
		assertEquals(new ReportCommand(), reportCommand);
	}
	
	@Test
	public void testUnknownCommandInput()
	{
		Command expected = new UnknownCommand();
		
		Command unknownCommand = InputHandler.handleInput(" ");
		assertEquals(expected, unknownCommand);
		
		unknownCommand =  InputHandler.handleInput("PLACE");
		assertEquals(expected, unknownCommand);
		
		unknownCommand = InputHandler.handleInput("PLACE 2 3 NORTH SOUTH");
		assertEquals(expected, unknownCommand);
		
		unknownCommand = InputHandler.handleInput("PLACE 2 3 SOUTHWEST");
		assertEquals(expected, unknownCommand);
		
		unknownCommand = InputHandler.handleInput("PLACE A 3 NORTH");
		assertEquals(expected, unknownCommand);
	}
}
