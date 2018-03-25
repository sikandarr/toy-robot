package com.reagroup.toyrobot.simulation.validation;

import java.util.Observable;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.Surface;
import com.reagroup.toyrobot.simulation.actions.Action;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
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
		this.position = (Position) position;
		Action action = (Action) actionObject;
		if (action.isProceed())
			action.setProceed(verify());
	}
}
