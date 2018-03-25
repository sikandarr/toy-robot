package com.reagroup.toyrobot.simulation.validation;

import java.util.Observable;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.Surface;
import com.reagroup.toyrobot.simulation.actions.Action;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class CheckPositionIsValid implements ValidationService
{
	private Position position;

	@NonNull
	private final Surface surface;

	@Override
	public boolean verify()
	{
		return surface.isPositionWithinBounds(position);
	}

	@Override
	public void update(Observable actionObject, Object position)
	{
		if (position != null)
		{
			Action action = (Action) actionObject;
			this.position = (Position) position;
			if (action.isProceed())
				action.setProceed(verify());
		}
	}
}
