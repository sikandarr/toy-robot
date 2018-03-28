package com.reagroup.toyrobot.controller;

import com.reagroup.toyrobot.controller.commands.Command;
import com.reagroup.toyrobot.controller.commands.ReportCommand;
import com.reagroup.toyrobot.model.Surface;
import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.view.CommandLineUI;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Controller
{
	private final SurfaceObject surfaceObject;
	private final Surface surface;
	private final CommandLineUI commandLineUI;
	
	public void handleInput(String input)
	{
		CommandInterpreter commandInterpreter = new CommandInterpreter(surfaceObject, surface);
		Command command = commandInterpreter.commandInterpreter(input);
		command.execute();
		
		if (command instanceof ReportCommand)
		{
			ReportCommand responseCommand = (ReportCommand) command;
			commandLineUI.update(responseCommand.getResponse());
		}
	}
}
