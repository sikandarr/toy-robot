package com.reagroup.toyrobot.commands;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PlaceCommand extends AbstractCommand
{
	@Override
	public void runCommand()
	{
	}
}
