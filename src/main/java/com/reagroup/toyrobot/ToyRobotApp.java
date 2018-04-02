package com.reagroup.toyrobot;

import java.io.IOException;
import com.reagroup.toyrobot.controller.Controller;
import com.reagroup.toyrobot.model.*;
import com.reagroup.toyrobot.simulation.*;
import com.reagroup.toyrobot.simulation.actions.*;
import com.reagroup.toyrobot.util.ArgsParser;
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

	public static void main(String[] args) throws SecurityException, IOException
	{
		ToyRobotApp app = new ToyRobotApp(args);
		app.run();
	}

	private ToyRobotApp(String ...args)
	{
		ArgsParser argsParser = new ArgsParser(args);
		
		Surface table = new SquareTable(5);
		
		toyRobot = new ToyRobot.RobotBuilder()
				.action(new PlaceAction(null))
				.action(new MoveFowardAction())
				.action(new RotateLeftAction())
				.action(new RotateRightAction())
				.build();

		cli = CommandLine.builder()
				.out(System.out)
				.scan(argsParser.getScanner())
				.build();

		controller = Controller
				.builder()
				.commandLine(cli)
				.surface(table)
				.surfaceObject(toyRobot)
				.build();

		cli.setController(controller);
		
		if (argsParser.isReadFromFile())
			cli.setWelcomeMessage("Hi! I will read the input command from the file and print the output here");
	}

	public void run()
	{
		cli.run();
	}
}