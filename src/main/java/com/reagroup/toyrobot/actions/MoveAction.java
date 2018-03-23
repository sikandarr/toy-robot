package com.reagroup.toyrobot.actions;

import com.reagroup.toyrobot.Direction;
import com.reagroup.toyrobot.Position;
import com.reagroup.toyrobot.SurfaceObject;

public class MoveAction extends Action
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
