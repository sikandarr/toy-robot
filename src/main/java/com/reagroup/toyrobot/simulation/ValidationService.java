package com.reagroup.toyrobot.simulation;

import java.util.Observable;
import java.util.Observer;

import com.reagroup.toyrobot.simulation.actions.Action;

public interface ValidationService extends Observer
{
	public boolean verify();
	
	@Override
	default public void update(Observable actionObject, Object arg)
	{
		Action action = (Action) actionObject;
		if (action.isProceed())
			action.setProceed(verify());
	}
}
