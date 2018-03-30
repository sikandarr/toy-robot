package com.reagroup.toyrobot.controller;

import java.util.logging.Logger;

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
	private static Logger log = Logger.getLogger(CommandInterpreter.class.getName());

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

		log.warning("Failed to interpret the command: " + commandString);
		return new UnknownCommand();
	}

	/**
	 * Parses the specified command string into an instance of
	 * ActionCommand that has PlaceAction as its action
	 * strategy.
	 * 
	 * @param commandString string to be parsed;
	 *            must follow the strict conventions of the PLACE command
	 *            as specified in the specs.
	 * 
	 * @return executable ActionCommand if parsing is successful
	 *         or UnknownCommand.
	 */

	private Command parsePlaceCommand(String commandString)
	{
		int x, y;
		Direction facing = null;

		try
		{
			String[] args = commandString.split("[ ]")[1].split(",");

			if (args.length != 3)
			{
				log.warning("PLACE command has insufficient arguments");
				return new UnknownCommand();
			}

			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
			facing = Direction.valueOf(args[2]);
		}
		catch (ArrayIndexOutOfBoundsException | IllegalArgumentException ex)
		{
			log.warning("PLACE command is incorrect");
			return new UnknownCommand();
		}

		Position position = new Position(x, y, facing);
		Action action = new PlaceAction(position);
		action.addObserver(new CheckPositionIsValid(surface));
		return new ActionCommand(surfaceObject, action);
	}
}
