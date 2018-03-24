package com.reagroup.toyrobot.simulation.actions;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlaceAction extends Action
{
	//new position
	private Position location;
	
	@Override
	public void performAction(SurfaceObject object)
	{
		object.setLocation(location);
	}

}
