package com.reagroup.toyrobot.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import lombok.Getter;

/**
 * 
 * This is a utility class that parses the command line
 * options and initializes the scanner and 
 * sets the logger to output to file if requested.
 *
 */

@Getter
public final class ArgsParser
{
	private Scanner scanner;
	private boolean readFromFile;
	private final static Logger log = Logger
			.getLogger(ArgsParser.class.getName());

	public ArgsParser(String... args)
	{
		this.scanner = new Scanner(System.in);
		this.readFromFile = false;

		if (args.length > 0)
			if (args.length % 2 == 0 && args.length <= 4)
			{
				for (int i = 0; i < args.length; i++)
				{
					switch (args[i])
					{
						case "-f":
							this.scanner = setScanner(args[++i]);
							this.readFromFile = true;
							break;

						case "-l":
							setupFileLogging(args[++i]);
							break;
					}
				}
			}
			else
			{
				log.warning("Parsing arguments failed: insufficient arguments");
				System.out.println("Incorrect usage. Check README.");
				System.exit(0);
			}
	}

	private Scanner setScanner(String fileName)
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

	private void setupFileLogging(String path)
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
			log.warning(
					e.getMessage() + "\n Logging will continue on console");
		}
	}
}
