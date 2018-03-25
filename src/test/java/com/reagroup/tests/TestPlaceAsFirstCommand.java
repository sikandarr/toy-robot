package com.reagroup.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import com.reagroup.toyrobot.simulation.ToyRobot;
import com.reagroup.toyrobot.simulation.actions.Action;
import com.reagroup.toyrobot.simulation.actions.MoveFowardAction;
import com.reagroup.toyrobot.simulation.actions.PlaceAction;
import com.reagroup.toyrobot.simulation.actions.RotateLeftAction;
import com.reagroup.toyrobot.simulation.actions.RotateRightAction;

public class TestPlaceAsFirstCommand
{
	private static Surface tableSquare;
	private static SurfaceObject toyRobot;
	private static FrontController controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		tableSquare = new SquareTable(5);
		initToyRobot();
		Scanner scan = new Scanner(System.in);
		controller = new FrontController(scan, System.out, toyRobot, tableSquare);
	}

	@Test
	public void testPlaceAsFirstCommand()
	{
		Command cmd = controller.commandInterpreter("PLACE 0 0 NORTH");
		cmd.execute();
		Position position = new Position(0, 0, Direction.NORTH);
		assertEquals(position, toyRobot.getPosition());
		initToyRobot();
	}
	
	public static void initToyRobot()
	{
		toyRobot = new ToyRobot(new ArrayList<Action>());
		toyRobot.addAction(new PlaceAction(null));
		toyRobot.addAction(new MoveFowardAction());
		toyRobot.addAction(new RotateLeftAction());
		toyRobot.addAction(new RotateRightAction());
	}

}
