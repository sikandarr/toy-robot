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
		app.init();
		app.run();
	}

	public void init()
	{
		Surface table = new SquareTable(5);

		toyRobot = new ToyRobot.RobotBuilder()
				.addAction(new PlaceAction(null))
				.addAction(new MoveFowardAction())
				.addAction(new RotateLeftAction())
				.addAction(new RotateRightAction())
				.create();

		controller = Controller
				.builder()
				.commandLineUI(cli)
				.surface(table)
				.surfaceObject(toyRobot)
				.build();

		try (Scanner scanner = new Scanner(System.in))
		{
			cli = CommandLine.builder()
					.controller(controller)
					.out(System.out)
					.scan(scanner)
					.build();
		}

	}
	
	public void run()
	{
		cli.run();
	}
}
