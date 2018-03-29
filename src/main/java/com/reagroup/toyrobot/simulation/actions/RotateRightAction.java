package com.reagroup.toyrobot.simulation.actions;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;

/**
 * Rotate a surface object towards its right.
 *
 */
public class RotateRightAction extends Action
{
	@Override
	public void performAction(SurfaceObject object)
	{
		Position position = object.getPosition();
		setChanged();
		notifyObservers(position);
		if (proceed)
		{
			position.setFacing(position.getFacing().turnRight());
			object.setPosition(position);
		}
	}
}
