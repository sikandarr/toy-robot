package com.reagroup.toyrobot.actions;

import java.util.List;

import com.reagroup.toyrobot.SurfaceObject;
import com.reagroup.toyrobot.VerifyActionService;

import lombok.Data;

@Data
public abstract class Action
{
	List<VerifyActionService> verifications;

	public boolean verify()
	{
		boolean proceed = true;
		for (VerifyActionService verification : verifications)
		{
			if (proceed)
				proceed = verification.verify();
		}
		return proceed;
	}

	public void perform(SurfaceObject object)
	{
		if (verify())
			performAction(object);
	}

	public abstract void performAction(SurfaceObject object);
}
