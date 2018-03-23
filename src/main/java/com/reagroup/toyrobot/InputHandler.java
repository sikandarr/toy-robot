package com.reagroup.toyrobot;

import com.reagroup.toyrobot.commands.Command;
import com.reagroup.toyrobot.commands.UnknownCommand;
import com.reagroup.toyrobot.commands.PlaceCommand;
import com.reagroup.toyrobot.commands.ReportCommand;

public class InputHandler
{
	Command handleInput(String command)
	{
		if (command.startsWith("PLACE"))
			return parsePlaceCommand(command);

		if (command.equals("REPORT"))
			return new ReportCommand(System.out);

		return new UnknownCommand();
	}

	Command parsePlaceCommand(String command)
	{
		String[] args = command.split(" ");
		int x = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		Direction facing = Direction.valueOf(args[3]);
		Position location = new Position(x, y, facing);
		return new PlaceCommand(location);
	}
}
