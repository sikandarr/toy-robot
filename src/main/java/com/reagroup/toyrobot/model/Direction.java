package com.reagroup.toyrobot.model;

/**
 * An enumeration of Directions as predefined in the specs i.e.
 * North, East, South, West.
 * 
 * Any changes to the definition of Direction, for example, 
 * inclusion of Directions such as NorthEast or SouthWest will 
 * invariably impact the code of this data type.
 */
public enum Direction
{
	NORTH, EAST, SOUTH, WEST;

	private Direction fromValue(int value)
	{
		// the modulus operator produces negative numbers
		// and hence we're using Math.floorMod
		// see stackoverflow (4412179) for discussion
		
		value = Math.floorMod(value, 4);
		if (value == 3)
			return WEST;
		else if (value == 2)
			return SOUTH;
		else if (value == 1)
			return EAST;
		else return NORTH;
	}

	public Direction turnRight()
	{
		return fromValue(this.ordinal() + 1);
	}

	public Direction turnLeft()
	{
		return fromValue(this.ordinal() - 1);
	}
}
