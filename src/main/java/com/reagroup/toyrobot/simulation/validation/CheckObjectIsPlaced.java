package com.reagroup.toyrobot.simulation.validation;

import java.util.Observable;

import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.actions.Action;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CheckObjectIsPlaced implements ValidationService
{
	private final SurfaceObject object;

	@Override
	public boolean verify()
	{
		return object.getPosition() != null;
	}

	@Override
	public void update(Observable actionObject, Object arg)
	{
		Action action = (Action) actionObject;
		if (action.isProceed())
			action.setProceed(verify());
	}
}
