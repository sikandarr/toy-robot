package com.reagroup.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.reagroup.toyrobot.InputHandler;
import com.reagroup.toyrobot.Position;
import com.reagroup.toyrobot.commands.Command;
import com.reagroup.toyrobot.commands.PlaceCommand;
import com.reagroup.toyrobot.commands.ReportCommand;
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
		assertEquals(placeCommand, new PlaceCommand(new Position(0, 1, Direction.NORTH)));
	}
	
	@Test
	public void testReportCommandInput()
	{
		Command reportCommand = inputHandler.handleInput("REPORT");
		assertEquals(reportCommand, new ReportCommand(System.out));
	}
}
