package com.reagroup.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.reagroup.toyrobot.controller.CommandInterpreter;
import com.reagroup.toyrobot.controller.commands.Command;
import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.Surface;
import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.SquareTable;

public class TestPlaceAsFirstCommand
{
	private static Surface tableSquare;
	private static SurfaceObject toyRobot;
	private static CommandInterpreter controller;
	private static String robotName = "Test Robot";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		tableSquare = new SquareTable(5);
		toyRobot = ConstructTestRobot.construct(robotName);
		controller = new CommandInterpreter(toyRobot, tableSquare);
	}

	@Test
	public void testPlaceAsFirstCommand()
	{
		Command cmd = controller.commandInterpreter("PLACE 0,0,NORTH");
		cmd.execute();
		Position position = new Position(0, 0, Direction.NORTH);
		assertEquals(position, toyRobot.getPosition());
	}

}
