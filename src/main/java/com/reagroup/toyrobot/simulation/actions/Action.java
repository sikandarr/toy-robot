package com.reagroup.toyrobot.simulation.actions;

import java.util.List;
import java.util.Observable;

import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.ValidationService;

public abstract class Action extends Observable
{
	List<ValidationService> beforeAction;
	List<ValidationService> afterAction;

	public boolean verifyBeforeAction()
	{
		boolean proceed = true;
		if (beforeAction != null)
			for (ValidationService service : beforeAction)
			{
				if (proceed)
					proceed = service.verify();
			}
		return proceed;
	}

	public boolean verifyAfterAction()
	{
		boolean proceed = true;
		if (afterAction != null)
			for (ValidationService service : afterAction)
			{
				if (proceed)
					proceed = service.verify();
			}
		return proceed;
	}

	public void perform(SurfaceObject object)
	{
		if (verifyBeforeAction())
			performAction(object);
	}

	public abstract void performAction(SurfaceObject object);
}
