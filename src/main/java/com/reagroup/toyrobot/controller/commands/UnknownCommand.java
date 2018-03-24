package com.reagroup.toyrobot.controller.commands;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Any input that can-not be interpreted into a specific
 * Command, including inputs that are incorrectly formatted
 * end up being an UnknownCommand.
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class UnknownCommand implements Command
{
	//nothing to execute
	public void execute()
	{
		return;
	}
}
