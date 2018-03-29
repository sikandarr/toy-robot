package com.reagroup.toyrobot.simulation.actions;

import java.util.Observable;
import com.reagroup.toyrobot.model.SurfaceObject;
import lombok.Getter;
import lombok.Setter;

/**
 * This is an abstract class for the actions that
 * can be performed by an object on surface. Actions are
 * Observable objects (from the observer pattern) to help
 * achieve the validity of an action; though this pattern is
 * mostly used in notifying Observers of a change in state
 * - it helps us here in decoupling the responsibility of
 * validating actions from this class. Furthermore, new validation
 * services can be registered as observers of specific action
 * which could have been problematic through pure dependency
 * injection.
 *
 */

@Getter
@Setter
public abstract class Action extends Observable
{
	protected boolean proceed = true;

	public abstract void performAction(SurfaceObject object);
}
