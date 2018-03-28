package com.reagroup.toyrobot.model;

/**
 * The abstract type SurfaceObject represents an Object
 * on the Surface of our universe. It has a Position
 * at which it exists and a list of actions that it can perform.
 */
import java.util.List;

import com.reagroup.toyrobot.simulation.actions.Action;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class SurfaceObject
{
	protected Position position;
	protected String name;

	/**
	 * This is the list of actions that a surface object can perform;
	 * this list as a property of this class only acts as a boolean
	 * placeholder - i.e. the methods of its instances should be never called
	 * and the presence of action instances only serve the purpose of
	 * validating an objects ability to perform a given action.
	 * While this choice may seem lumpy it makes our object dynamic
	 * -- all actions that exist in the system can be added or
	 * removed from outside the class or even at runtime.
	 * 
	 * Note: this list should ideally be unique and we can force this constraint
	 * either by restricting its access to subclasses or by using sets but what
	 * we will defer this decision on subclasses.
	 */
	protected List<Action> actions;

	@Override
	public String toString()
	{
		return name + "Position: " + position.toString();
	}
	
	public abstract void performAction(Action action);
}
