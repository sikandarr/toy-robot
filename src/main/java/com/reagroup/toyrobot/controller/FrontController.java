package com.reagroup.toyrobot.controller;

import java.io.PrintStream;
import java.util.Scanner;
import com.reagroup.toyrobot.controller.commands.*;
import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.Surface;
import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.actions.Action;
import com.reagroup.toyrobot.simulation.actions.MoveFowardAction;
import com.reagroup.toyrobot.simulation.actions.PlaceAction;
import com.reagroup.toyrobot.simulation.actions.RotateLeftAction;
import com.reagroup.toyrobot.simulation.actions.RotateRightAction;
import com.reagroup.toyrobot.simulation.validation.CheckObjectIsPlaced;
import com.reagroup.toyrobot.simulation.validation.CheckPositionIsValid;

import lombok.AllArgsConstructor;

/**
 * This class is responsible to translate user inputs and
 * return the respective commands.
 *
 */

@AllArgsConstructor
public class FrontController
{
	private final Scanner scan;
	private final PrintStream out;
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
			return new ReportCommand(out, surfaceObject);
		}

		if (commandString.equals("LEFT"))
		{
			Action action = new RotateLeftAction();
			action.addObserver(new CheckObjectIsPlaced(surfaceObject));
			LeftCommand cmd = new LeftCommand(surfaceObject, action);
			return cmd;
		}

		if (commandString.equals("RIGHT"))
		{
			Action action = new RotateRightAction();
			action.addObserver(new CheckObjectIsPlaced(surfaceObject));
			Command cmd = new RightCommand(surfaceObject, action);
			return cmd;
		}

		if (commandString.equals("MOVE"))
		{
			Action action = new MoveFowardAction();
			action.addObserver(new CheckPositionIsValid(surface));
			action.addObserver(new CheckObjectIsPlaced(surfaceObject));
			Command cmd = new MoveCommand(surfaceObject, action);
			return cmd;
		}

		return new UnknownCommand();
	}

	private Command parsePlaceCommand(String command)
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
		catch (ArrayIndexOutOfBoundsException | IllegalArgumentException ex)
		{
			return new UnknownCommand();
		}

		Position position = new Position(x, y, facing);
		Action action = new PlaceAction(position);
		action.addObserver(new CheckPositionIsValid(surface));
		return new PlaceCommand(surfaceObject, action);
	}

	public Command readInput()
	{
		return commandInterpreter(scan.nextLine());
	}
}
