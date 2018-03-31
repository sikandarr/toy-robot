package com.reagroup.toyrobot.simulation.actions;

import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;


/**
 * Provides the logic to increment a SurfaceObject's
 * x or y position in the direction it is facing.
 *
 */
public class MoveFowardAction extends Action
{
	@Override
	public void performAction(SurfaceObject object)
	{
		setChanged();
		notifyObservers();
		if (proceed)
		{
			Position current = object.getPosition();

			int x = current.getX();
			int y = current.getY();

			if (current.getFacing() == Direction.NORTH)
				y++;
			else if (current.getFacing() == Direction.SOUTH)
				y--;
			else if (current.getFacing() == Direction.EAST)
				x++;
			else x--;

			Position temp = new Position(x, y, current.getFacing());
			
			setChanged();
			notifyObservers(temp);

			if (proceed)
				object.setPosition(temp);
		}
	}

}
