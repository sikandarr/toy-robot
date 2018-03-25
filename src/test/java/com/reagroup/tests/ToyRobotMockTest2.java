package com.reagroup.tests;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import com.reagroup.toyrobot.controller.FrontController;
import com.reagroup.toyrobot.controller.commands.Command;
import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.Surface;
import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.SquareTable;

public class ToyRobotMockTest2
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

		Command cmd = controller.commandInterpreter(Cmd.PLACE + " 1 2 EAST");
		cmd.execute();

		cmd = controller.commandInterpreter(Cmd.MOVE);
		cmd.execute();
		
		cmd = controller.commandInterpreter(Cmd.MOVE);
		cmd.execute();
		
		cmd = controller.commandInterpreter(Cmd.LEFT);
		cmd.execute();
		
		cmd = controller.commandInterpreter(Cmd.MOVE);
		cmd.execute();
		
		cmd = controller.commandInterpreter(Cmd.REPORT);
		cmd.execute();
		
		assertEquals(new Position(3, 3, Direction.NORTH), toyRobot.getPosition());
	}
}
