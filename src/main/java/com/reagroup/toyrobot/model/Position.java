package com.reagroup.toyrobot.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * This class represents an object's position on the surface
 * that includes its x, y coordinates and the Direction in which
 * it's facing.
 * 
 * The objects of this class are immutable.
 *
 */

@AllArgsConstructor
@EqualsAndHashCode
public class Position
{
	@Getter
	private final int x;
	@Getter
	private final int y;
	@Getter
	private final Direction facing;

	@Override
	public String toString()
	{
		return x + " " + y + " " + facing.toString();
	}
}
