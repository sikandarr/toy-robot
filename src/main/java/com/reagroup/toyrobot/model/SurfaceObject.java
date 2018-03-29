package com.reagroup.toyrobot.model;

/**
 * The abstract type SurfaceObject represents an Object
 * on the Surface of our universe. It has a Position
 * at which it exists and a list of actions that it can perform.
 */
import java.util.List;
import com.reagroup.toyrobot.simulation.actions.Action;

import lombok.Getter;
import lombok.Setter;

public abstract class SurfaceObject
{
	@Getter @Setter protected Position position;
	@Getter @Setter protected String name;

	/**
	 * This is the list of actions that a surface object can perform;
	 * this list as a property of this class only acts as a boolean
	 * placeholder - i.e. the methods of its instances should be never called
	 * and the presence of action instances only serve the purpose of
	 * validating an objects ability to perform a given action.
	 * While this choice may seem aberrant it makes our object dynamic
	 * -- all actions that exist in the system can be added or
	 * removed from outside the class or even at runtime.
	 * 
	 * Note: this list should ideally be unique and we can force this constraint
	 * either by restricting its access to subclasses or by using sets but in the
	 * interest of keeping  it simple what is given here should suffice.
	 */
	protected List<Action> actions;
	public abstract void performAction(Action action);
}
