package com.reagroup.toyrobot.model;

/**
 * The abstract type SurfaceObject represents an Object
 * on the Surface of our Game universe. It has a Position
 * at which it exists and a list of actions that it can perform.
 */
import java.util.List;

import com.reagroup.toyrobot.simulation.actions.Action;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class SurfaceObject
{
	protected Position position;
	@NonNull
	protected List<Action> actions;

	public void performAction(Action action)
	{
		for (Action performable : actions)
			if (action.getClass().equals(performable.getClass()))
				action.performAction(this);
	}

	public void addAction(Action action)
	{
		actions.add(action);
	}

	public boolean removeAction(Action action)
	{
		return actions.remove(action);
	}

	@Override
	public String toString()
	{
		return position.toString();
	}
}
