package com.reagroup.toyrobot.simulation;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.Surface;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SquareTable implements Surface
{
	private int length;

	@Override
	public boolean isPositionWithinBounds(Position position)
	{
		return !(position.getX() > length || position.getY() > length || position.getX() < 0 || position.getY() < 0);
	}
}
