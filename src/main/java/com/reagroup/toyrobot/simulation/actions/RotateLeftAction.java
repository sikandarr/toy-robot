package com.reagroup.toyrobot.simulation.actions;

import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;
import lombok.EqualsAndHashCode;


/**
 * Rotate's a surface object towards its left
 *
 */
@EqualsAndHashCode(callSuper=false)
public class RotateLeftAction extends Action
{
	@Override
	public void performAction(SurfaceObject surfaceObject)
	{	
		/** check to see if the objects is placed **/
		setChanged();
		notifyObservers();
		if (proceed)
		{
			int x = surfaceObject.getPosition().getX();
			int y = surfaceObject.getPosition().getY();
			Direction facing = surfaceObject.getPosition().getFacing().turnLeft();
			
			Position position = new Position(x, y, facing);
			surfaceObject.setPosition(position);
		}
	}
}
