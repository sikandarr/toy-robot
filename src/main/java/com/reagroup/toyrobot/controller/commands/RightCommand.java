package com.reagroup.toyrobot.controller.commands;

import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.actions.Action;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class RightCommand implements Command
{
	private SurfaceObject object;
	private Action action;

	@Override
	public void execute()
	{
		object.performAction(action);
	}
}
