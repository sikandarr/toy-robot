package com.reagroup.toyrobot.model;

/**
 * The abstract type SurfaceObject represents an Object
 * on the Surface of our Game universe. It has a Position
 * at which it exists and a list of actions that it can perform.
 */
import java.util.List;

import com.reagroup.toyrobot.simulation.actions.Action;
import lombok.Getter;

public abstract class SurfaceObject
{
	@Getter
	protected Position position;
	protected String name;

	/**
	 * This is the list of actions that a surface object can perform;
	 * this list as a property of this class only acts as a boolean
	 * placeholder - i.e. the methods of the actions are never called
	 * the presence action instances only serve the purpose of
	 * validating an objects ability to perform a given action.
	 * While, this choice may seem lumpy it makes our object dynamic
	 * -- all actions that exist in the system can be added or
	 * removed from outside the class or even at runtime.
	 * 
	 * Note: this list should ideally be unique and we can force this constraint
	 * either by restricting its access to subclasses or by using sets but what
	 * we have here serves our present needs.
	 */
	private List<Action> actions;

	protected SurfaceObject(List<Action> actions)
	{
		this.actions = actions;
	}

	public void performAction(Action action)
	{
		for (Action performable : actions)
			if (action.getClass().equals(performable.getClass()))
				action.performAction(this);
	}

	protected void addAction(Action action)
	{
		if (actions.indexOf(action) == -1)
			actions.add(action);
	}

	protected void removeAction(Action action)
	{
		actions.remove(action);
	}

	@Override
	public String toString()
	{
		return name + "Position: " + position.toString();
	}
}
