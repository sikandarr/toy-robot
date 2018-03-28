package com.reagroup.tests;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import com.reagroup.toyrobot.controller.CommandInterpreter;
import com.reagroup.toyrobot.controller.commands.Command;
import com.reagroup.toyrobot.controller.commands.ReportCommand;
import com.reagroup.toyrobot.model.*;
import com.reagroup.toyrobot.simulation.*;

public class ToyRobotMockTest
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
	public void testMultipleCommands()
	{
		Command cmd = controller.commandInterpreter(Cmd.REPORT);
		cmd.execute();
		assertEquals(null, toyRobot.getPosition());
		assertEquals(robotName + " Not Placed", ((ReportCommand) cmd).getResponse());

		cmd = controller.commandInterpreter(Cmd.PLACE + " 0,0,NORTH");
		cmd.execute();
		assertEquals(new Position(0, 0, Direction.NORTH), toyRobot.getPosition());

		cmd = controller.commandInterpreter(Cmd.LEFT);
		cmd.execute();
		assertEquals(new Position(0, 0, Direction.WEST), toyRobot.getPosition());
		
		cmd = controller.commandInterpreter(Cmd.REPORT);
		cmd.execute();
		assertEquals(new Position(0, 0, Direction.WEST), toyRobot.getPosition());
		assertEquals("0 0 WEST", ((ReportCommand) cmd).getResponse());

		cmd = controller.commandInterpreter(Cmd.MOVE);
		cmd.execute();
		
		cmd = controller.commandInterpreter(Cmd.REPORT);
		cmd.execute();
		assertEquals(new Position(0, 0, Direction.WEST), toyRobot.getPosition());
	}
}
