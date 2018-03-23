package com.reagroup.toyrobot;

import java.util.List;

import com.reagroup.toyrobot.actions.Action;

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