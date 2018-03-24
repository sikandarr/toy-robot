package com.reagroup.toyrobot.simulation.actions;

import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;

public class MoveFowardAction extends Action
{
	@Override
	public void performAction(SurfaceObject object)
	{
		Position current = object.getLocation();

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

		if (verifyAfterAction())
			object.setLocation(temp);
	}

}
