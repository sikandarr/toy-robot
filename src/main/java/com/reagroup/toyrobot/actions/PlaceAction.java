package com.reagroup.toyrobot.actions;

import com.reagroup.toyrobot.Position;
import com.reagroup.toyrobot.SurfaceObject;

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
