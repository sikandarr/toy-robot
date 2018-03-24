package com.reagroup.toyrobot.actions;

import java.util.List;

import com.reagroup.toyrobot.SurfaceObject;
import com.reagroup.toyrobot.ValidationService;

public abstract class Action
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
