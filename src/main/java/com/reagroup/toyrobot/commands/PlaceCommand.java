package com.reagroup.toyrobot.commands;

import com.reagroup.toyrobot.Position;
import com.reagroup.toyrobot.SurfaceObject;
import com.reagroup.toyrobot.actions.PlaceAction;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlaceCommand extends Command
{
	private Position location;
	
	@Override
	public void execute(SurfaceObject object)
	{
		object.performAction(new PlaceAction(this.location));
	}
}
