package com.reagroup.toyrobot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
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
	private static Scanner scan = new Scanner(System.in);
	private final static Logger log = Logger
			.getLogger(ToyRobot.class.getName());

	public static void main(String[] args) throws SecurityException, IOException
	{
		parseArgs(args);
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
				.build();

		cli = CommandLine.builder()
				.out(System.out)
				.scan(scan)
				.build();

		controller = Controller
				.builder()
				.commandLine(cli)
				.surface(table)
				.surfaceObject(toyRobot)
				.build();

		cli.setController(controller);

	}

	private static void parseArgs(String... args)
	{
		if (args.length <= 0)
			return;

		if ((!(args.length % 2 == 0)) || args.length > 4)
		{
			log.warning("Incorrect usage. Insufficient arguments supplied");
			System.out.println("Incorrect usage. Refer to documentation.");
			System.exit(0);
		}
		
		for (int i = 0; i < args.length; i++)
		{
			switch (args[i])
			{
				case "-f":
					scan = setFileScanner(args[++i]);
					break;

				case "-l":
					setupFileLogging(args[++i]);
					break;
			}
		}
	}

	private static Scanner setFileScanner(String fileName)
	{
		try
		{
			return new Scanner(new File(fileName));
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("File not found: " + fileName);
			System.exit(0);
			return null;
		}
	}

	private static void setupFileLogging(String path)
	{
		File file = new File(path);

		if (!file.isDirectory())
		{
			log.warning(path
					+ " is not a folder. Logging will continue on console");
			return;
		}

		Logger rootLogger = Logger.getLogger("");
		FileHandler fileHandler = null;

		try
		{
			fileHandler = new FileHandler(path + (path.endsWith("\\") == true
					? "toy-robot.log" : "\\toy-robot.log"));
			Handler[] handlers = rootLogger.getHandlers();
			for (Handler handler : handlers)
			{
				rootLogger.removeHandler(handler);
			}
			rootLogger.addHandler(fileHandler);
		}
		catch (SecurityException | IOException e)
		{
			rootLogger.warning(
					e.getMessage() + "\n Logging will continue on console");
		}
	}

	public void run()
	{
		cli.run();
	}
}