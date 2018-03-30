package com.reagroup.toyrobot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.reagroup.toyrobot.controller.Controller;
import com.reagroup.toyrobot.model.*;
import com.reagroup.toyrobot.simulation.*;
import com.reagroup.toyrobot.simulation.actions.*;
import com.reagroup.toyrobot.view.CommandLine;

/**
 * The class containing main method for the toy-robot application.
 * The application is designed using the MVC architecture
 * design pattern and hence this class builds the required models,
 * controller, and view and runs the application.
 *
 */
public final class ToyRobotApp
{
	private SurfaceObject toyRobot;
	private CommandLine cli;
	private Controller controller;

	public static void main(String[] args)
	{
		ToyRobotApp app = new ToyRobotApp(args);
		app.run();
	}

	private ToyRobotApp(String ...args)
	{
		Surface table = new SquareTable(5);
		
		toyRobot = new ToyRobot.RobotBuilder()
				.action(new PlaceAction(null))
				.action(new MoveFowardAction())
				.action(new RotateLeftAction())
				.action(new RotateRightAction())
				.build();

		cli = CommandLine.builder()
				.out(System.out)
				.scan(parseArgs(args))
				.build();

		controller = Controller
				.builder()
				.commandLine(cli)
				.surface(table)
				.surfaceObject(toyRobot)
				.build();
		
		cli.setController(controller);
		if(args.length > 0)
			cli.setWelcomeMessage("Hello, I will read the commands from file and print the required output here.");

	}
	
	private Scanner parseArgs(String ...args)
	{	
		if (args.length > 0)
		{
			try
			{
				return new Scanner(new File(args[0]));
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("File not found: " + args[0]);
				System.exit(0);
				return null;
			}
		}
		else
			return new Scanner(System.in);
	}

	public void run()
	{
		cli.run();
	}
}
