package com.reagroup.toyrobot;

public enum Direction
{
	NORTH, EAST, SOUTH, WEST;

	private Direction fromValue(int value)
	{
		value = value % 4;
		if (value == 3) return WEST;
		else if (value == 2) return SOUTH;
		else if (value == 1) return EAST;
		else return NORTH;
	}

	public Direction turnLeft()
	{
		return fromValue(this.ordinal() + 1);
	}

	public Direction turnRight()
	{
		return fromValue(this.ordinal() - 1);
	}
}
