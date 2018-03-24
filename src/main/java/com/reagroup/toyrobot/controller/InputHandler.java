package com.reagroup.toyrobot.controller;

import com.reagroup.toyrobot.controller.commands.*;
import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;

/**
 * This class is responsible to translate user inputs and
 * return the respective commands.
 * <p>
 * Note: This class is NOT responsible to inject properties 
 * into Command objects that maybe required by these objects to
 * perform their service with the exception of cases of inputs that
 * contain arguments - for example, PLACE command.
 *
 */

public class InputHandler
{
	/**
	 * Returns a Command object that can then be executed
	 * by a simulation engine. It is the responsibility of
	 * the client to ensure that relevant dependencies are injected 
	 * into the returned object before execution.
	 * 
	 * @param command String to be interpreted
	 * @return the corresponding command or an UnknownCommand 
	 * when the argument can-not be interpreted
	 */
	public static Command handleInput(String command)
	{
		if (command.startsWith("PLACE"))
			return parsePlaceCommand(command);

		if (command.equals("REPORT"))
			return new ReportCommand();
		
		if (command.equals("LEFT"))
			return new LeftCommand();
		
		if (command.equals("RIGHT"))
			return new ReportCommand();
		
		if (command.equals("MOVE"))
			return new MoveCommand();

		return new UnknownCommand();
	}

	private static Command parsePlaceCommand(String command)
	{
		String[] args = command.split(" ");
		
		if (args.length > 4)
			return new UnknownCommand();
		
		int x, y;
		Direction facing = null;
		
		try
		{
			x = Integer.parseInt(args[1]);
			y = Integer.parseInt(args[2]);
			facing = Direction.valueOf(args[3]);
		}
		catch(ArrayIndexOutOfBoundsException | IllegalArgumentException ex)
		{
			return new UnknownCommand();
		}
				
		Position location = new Position(x, y, facing);
		return new PlaceCommand(location);
	}
}
