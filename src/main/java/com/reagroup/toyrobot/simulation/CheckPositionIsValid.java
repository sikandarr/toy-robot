package com.reagroup.toyrobot.simulation;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.Surface;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CheckPositionIsValid implements ValidationService
{
	private final Position position;
	private final Surface surface;

	@Override
	public boolean verify()
	{
		return surface.isPositionWithinBounds(position);
	}
}
