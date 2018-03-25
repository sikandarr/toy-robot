package com.reagroup.toyrobot.controller.commands;

import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.actions.Action;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Data
public class LeftCommand implements Command
{
	private SurfaceObject object;
	private Action action;

	@Override
	public void execute()
	{
		object.performAction(action);
	}

}
