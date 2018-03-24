package com.reagroup.toyrobot.model;


/**
 * The abstract type SurfaceObject represents an Object
 * on the Surface of our Game universe. It has a Position
 * at which it exists and a list of actions that it can perform.
 */
import java.util.List;

import com.reagroup.toyrobot.simulation.actions.Action;

import lombok.Data;

@Data
public abstract class SurfaceObject
{
	protected Position location;
	protected List<Action> actions;

	public void performAction(Action action)
	{
		for (Action performable : actions)
			if (action.getClass().equals(performable))
				action.perform(this);
	}
	
	@Override
	public String toString()
	{
		return location.toString();
	}
}
