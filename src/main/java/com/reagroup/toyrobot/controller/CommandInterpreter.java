package com.reagroup.toyrobot.controller;

import com.reagroup.toyrobot.controller.commands.*;
import com.reagroup.toyrobot.model.*;
import com.reagroup.toyrobot.simulation.actions.*;
import com.reagroup.toyrobot.simulation.validation.*;
import lombok.AllArgsConstructor;

/**
 * The command factory that is responsible to translate user inputs
 * and return new commands that may then be executed by a simulation
 * engine.
 *
 */

@AllArgsConstructor
public class CommandInterpreter
{
	private final SurfaceObject surfaceObject;
	private final Surface surface;

	/**
	 * Returns a Command object that can then be executed
	 * by a simulation engine.
	 * 
	 * @param commandString String to be interpreted
	 * @return the corresponding command or an UnknownCommand
	 *         when the argument can-not be interpreted
	 */
	public Command commandInterpreter(String commandString)
	{
		if (commandString.startsWith("PLACE"))
		{
			return parsePlaceCommand(commandString);
		}

		if (commandString.equals("REPORT"))
		{
			return new ReportCommand(surfaceObject);
		}

		if (commandString.equals("LEFT"))
		{
			Action action = new RotateLeftAction();
			action.addObserver(new CheckObjectIsPlaced(surfaceObject));
			Command cmd = new ActionCommand(surfaceObject, action);
			return cmd;
		}

		if (commandString.equals("RIGHT"))
		{
			Action action = new RotateRightAction();
			action.addObserver(new CheckObjectIsPlaced(surfaceObject));
			Command cmd = new ActionCommand(surfaceObject, action);
			return cmd;
		}

		if (commandString.equals("MOVE"))
		{
			Action action = new MoveFowardAction();
			action.addObserver(new CheckPositionIsValid(surface));
			action.addObserver(new CheckObjectIsPlaced(surfaceObject));
			Command cmd = new ActionCommand(surfaceObject, action);
			return cmd;
		}

		return new UnknownCommand();
	}

	/**
	 * Parses the specified command string into an instance of
	 * ActionCommand that has PlaceAction as its action
	 * strategy.
	 * 
	 * @param command string to be parsed;
	 *            must follow the strict conventions of the PLACE command
	 *            as specified in the specs.
	 * 
	 * @return executable ActionCommand if parsing is successful
	 *         or UnknownCommand.
	 */

	private Command parsePlaceCommand(String command)
	{
		int x, y;
		Direction facing = null;

		try
		{
			String[] args = command.split("[ ]")[1].split(",");

			if (args.length > 3)
				return new UnknownCommand();

			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
			facing = Direction.valueOf(args[2]);
		}
		catch (ArrayIndexOutOfBoundsException | IllegalArgumentException ex)
		{
			return new UnknownCommand();
		}

		Position position = new Position(x, y, facing);
		Action action = new PlaceAction(position);
		action.addObserver(new CheckPositionIsValid(surface));
		return new ActionCommand(surfaceObject, action);
	}
}
