package com.reagroup.tests;

import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.BeforeClass;
import org.junit.Test;
import com.reagroup.toyrobot.controller.FrontController;
import com.reagroup.toyrobot.controller.commands.Command;
import com.reagroup.toyrobot.model.*;
import com.reagroup.toyrobot.simulation.*;

public class ToyRobotMockTest
{
	private static Surface tableSquare;
	private static SurfaceObject toyRobot;
	private static FrontController controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		tableSquare = new SquareTable(5);
		toyRobot = MockRobot.construct();
		Scanner scan = new Scanner(System.in);
		controller = new FrontController(scan, System.out, toyRobot, tableSquare);
	}

	@Test
	public void testMultipleCommands()
	{
		Command cmd = controller.commandInterpreter(Cmd.REPORT);
		cmd.execute();
		assertEquals(null, toyRobot.getPosition());

		cmd = controller.commandInterpreter(Cmd.PLACE + " 0 0 NORTH");
		cmd.execute();
		assertEquals(new Position(0, 0, Direction.NORTH), toyRobot.getPosition());

		cmd = controller.commandInterpreter(Cmd.LEFT);
		cmd.execute();
		assertEquals(new Position(0, 0, Direction.WEST), toyRobot.getPosition());
		
		cmd = controller.commandInterpreter(Cmd.REPORT);
		cmd.execute();
		assertEquals(new Position(0, 0, Direction.WEST), toyRobot.getPosition());

		cmd = controller.commandInterpreter(Cmd.MOVE);
		cmd.execute();
		
		cmd = controller.commandInterpreter(Cmd.REPORT);
		cmd.execute();
		assertEquals(new Position(0, 0, Direction.WEST), toyRobot.getPosition());
	}
}
