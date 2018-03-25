package com.reagroup.toyrobot.simulation.actions;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;

public class RotateLeftAction extends Action
{
	@Override
	public void performAction(SurfaceObject object)
	{
		Position position = object.getPosition();
		notifyObservers(position);
		if (proceed)
		{
			position.setFacing(position.getFacing().turnLeft());
			object.setPosition(position);
		}
	}
}
