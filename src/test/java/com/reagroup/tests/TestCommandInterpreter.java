package com.reagroup.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.reagroup.toyrobot.controller.CommandInterpreter;
import com.reagroup.toyrobot.controller.commands.*;
import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.SquareTable;
import com.reagroup.toyrobot.simulation.actions.PlaceAction;

public class TestCommandInterpreter
{
	private static CommandInterpreter controller;
	private static SurfaceObject surfaceObject;
	private static String robotName = "Test Robot";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		surfaceObject = ConstructTestRobot.construct(robotName);
		controller = new CommandInterpreter(surfaceObject, new SquareTable(5));
	}

	@Test
	public void testPlaceCommandInput()
	{
		Command placeCommand = controller.commandInterpreter("PLACE 0,1,NORTH");
		Position position = new Position(0, 1, Direction.NORTH);
		assertEquals(new ActionCommand(surfaceObject, new PlaceAction(position)), placeCommand);
	}

	@Test
	public void testReportCommandInput()
	{
		Command reportCommand = controller.commandInterpreter("REPORT");
		assertEquals(new ReportCommand(surfaceObject), reportCommand);
	}

	@Test
	public void testUnknownCommandInput()
	{
		Command expected = new UnknownCommand();

		Command unknownCommand = controller.commandInterpreter(" ");
		assertEquals(expected, unknownCommand);

		unknownCommand = controller.commandInterpreter("PLACE");
		assertEquals(expected, unknownCommand);

		unknownCommand = controller.commandInterpreter("PLACE 2 3 NORTH SOUTH");
		assertEquals(expected, unknownCommand);

		unknownCommand = controller.commandInterpreter("PLACE 2 3 SOUTHWEST");
		assertEquals(expected, unknownCommand);

		unknownCommand = controller.commandInterpreter("PLACE A 3 NORTH");
		assertEquals(expected, unknownCommand);
	}
}
