package com.reagroup.toyrobot.simulation.actions;

import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;

/**
 * Rotate a surface object towards its right.
 *
 */
public class RotateRightAction extends Action
{
	@Override
	public void performAction(SurfaceObject surfaceObject)
	{
		/** checks if the surface object is placed **/
		setChanged();
		notifyObservers();
		
		if (proceed)
		{
			int x = surfaceObject.getPosition().getX();
			int y = surfaceObject.getPosition().getY();
			Direction facing = surfaceObject.getPosition().getFacing().turnRight();
			
			Position position = new Position(x, y, facing);
			surfaceObject.setPosition(position);
		}
	}
}
