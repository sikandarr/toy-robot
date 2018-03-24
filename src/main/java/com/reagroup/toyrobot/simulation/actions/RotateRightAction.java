package com.reagroup.toyrobot.simulation.actions;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;

public class RotateRightAction extends Action
{
	@Override
	public void performAction(SurfaceObject object)
	{
		Position position = object.getLocation();
		position.setFacing(position.getFacing().turnRight());
		object.setLocation(position);
	}
}
