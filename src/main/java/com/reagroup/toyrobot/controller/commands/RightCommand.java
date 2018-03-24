package com.reagroup.toyrobot.controller.commands;

import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.actions.RotateRightAction;

public class RightCommand implements Command
{
	private SurfaceObject object;

	@Override
	public void execute()
	{
		object.performAction(new RotateRightAction());
	}
}
