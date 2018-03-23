package com.reagroup.toyrobot.commands;

import com.reagroup.toyrobot.SurfaceObject;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UnknownCommand extends Command
{
	public void execute(SurfaceObject object)
	{
		return;
	}
}
