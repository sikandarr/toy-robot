package com.reagroup.toyrobot;

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
