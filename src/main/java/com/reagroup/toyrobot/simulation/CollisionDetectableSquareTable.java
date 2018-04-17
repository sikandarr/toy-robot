package com.reagroup.toyrobot.simulation;

import com.reagroup.toyrobot.model.CollissionDetectableSurface;
import com.reagroup.toyrobot.model.Position;

public class CollisionDetectableSquareTable extends SquareTable
		implements CollissionDetectableSurface
{

	public CollisionDetectableSquareTable(int length)
	{
		super(length);
	}

	@Override
	public boolean detectCollision(Position position1, Position position2)
	{
		if ((position1.getX() == position2.getX())
				&& (position2.getX() == position2.getY()))
			return true;
		else return false;
	}

}
