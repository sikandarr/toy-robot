package com.reagroup.toyrobot.controller.commands;

import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.actions.MoveFowardAction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class MoveCommand implements Command
{
	private SurfaceObject object;
	
	@Override
	public void execute()
	{
		object.performAction(new MoveFowardAction());
	}

}
