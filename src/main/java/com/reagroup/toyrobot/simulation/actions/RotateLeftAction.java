package com.reagroup.toyrobot.simulation.actions;

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
	public void performAction(SurfaceObject object)
	{
		Position position = object.getPosition();
		setChanged();
		notifyObservers();
		if (proceed)
		{
			position.setFacing(position.getFacing().turnLeft());
			object.setPosition(position);
		}
	}
}
