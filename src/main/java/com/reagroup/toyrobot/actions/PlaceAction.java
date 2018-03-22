package com.reagroup.toyrobot.actions;

import java.util.List;

import com.reagroup.toyrobot.Position;
import com.reagroup.toyrobot.SurfaceObject;

public class PlaceAction extends Action
{
	//new position
	private Position location;
	
	public PlaceAction(Position location)
	{
		this.location = location;
	}

	@Override
	public void performAction(SurfaceObject object)
	{
		object.setLocation(location);
	}

}
