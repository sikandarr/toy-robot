package com.reagroup.toyrobot;

import java.util.Scanner;

import com.reagroup.toyrobot.controller.Controller;
import com.reagroup.toyrobot.model.*;
import com.reagroup.toyrobot.simulation.*;
import com.reagroup.toyrobot.simulation.actions.*;
import com.reagroup.toyrobot.view.CommandLine;

public final class ToyRobotApp
{
	private SurfaceObject toyRobot;
	private CommandLine cli;
	private Controller controller;

	public static void main(String args[])
	{
		ToyRobotApp app = new ToyRobotApp();
		app.run();
	}

	private ToyRobotApp()
	{
		Surface table = new SquareTable(5);
		toyRobot = new ToyRobot.RobotBuilder()
				.action(new PlaceAction(null))
				.action(new MoveFowardAction())
				.action(new RotateLeftAction())
				.action(new RotateRightAction())
				.create();

		cli = CommandLine.builder()
				.out(System.out)
				.scan(new Scanner(System.in))
				.build();

		controller = Controller
				.builder()
				.commandLine(cli)
				.surface(table)
				.surfaceObject(toyRobot)
				.build();
		
		cli.setController(controller);

	}

	public void run()
	{
		cli.run();
	}
}
