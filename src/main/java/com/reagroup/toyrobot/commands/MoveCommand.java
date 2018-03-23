package com.reagroup.toyrobot.commands;

import com.reagroup.toyrobot.SurfaceObject;
import com.reagroup.toyrobot.actions.MoveAction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class MoveCommand implements Command
{
	@Override
	public void execute(SurfaceObject object)
	{
		object.performAction(new MoveAction());
	}

}
