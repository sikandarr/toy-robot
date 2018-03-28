package com.reagroup.toyrobot.controller;

import com.reagroup.toyrobot.controller.commands.Command;
import com.reagroup.toyrobot.controller.commands.ResponseCommand;
import com.reagroup.toyrobot.model.Surface;
import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.view.View;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Controller
{
	private final SurfaceObject surfaceObject;
	private final Surface surface;
	private final View commandLine;
	
	public void handleInput(String input)
	{
		CommandInterpreter commandInterpreter = new CommandInterpreter(surfaceObject, surface);
		Command command = commandInterpreter.commandInterpreter(input);
		command.execute();
		
		if (command instanceof ResponseCommand)
		{
			ResponseCommand responseCommand = (ResponseCommand) command;
			commandLine.update((String) responseCommand.getResponse());
		}
	}
}
