package com.reagroup.toyrobot.controller.commands;

import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.actions.Action;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

/*
 * This class is the concrete implementation of the Command
 * interface and represents commands that change the state of
 * the SurafceObject by calling its performAction method. 
 * The action that is to be performed by the object is dependency
 * injected by the client class.
 * <p>
 * The objects of this class are immutable.
 */

@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ActionCommand implements Command
{
	private final SurfaceObject object;
	private final Action action;
	
	public void execute()
	{
		object.performAction(action);
	}

}
