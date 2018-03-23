package com.reagroup.toyrobot;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CheckPositionIsValid implements ValidationService
{
	Position position;
	Surface surface;

	@Override
	public boolean verify()
	{
		return surface.isPositionWithinBounds(position);
	}
}
