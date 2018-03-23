package com.reagroup.toyrobot;

import com.reagroup.toyrobot.commands.Command;
import com.reagroup.toyrobot.commands.UnknownCommand;
import com.reagroup.toyrobot.commands.PlaceCommand;
import com.reagroup.toyrobot.commands.ReportCommand;

public class InputHandler
{
	public Command handleInput(String command)
	{
		if (command.startsWith("PLACE"))
			return parsePlaceCommand(command);

		if (command.equals("REPORT"))
			return new ReportCommand(System.out);

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
		catch(ArrayIndexOutOfBoundsException | IllegalArgumentException ex)
		{
			return new UnknownCommand();
		}
				
		Position location = new Position(x, y, facing);
		return new PlaceCommand(location);
	}
}
