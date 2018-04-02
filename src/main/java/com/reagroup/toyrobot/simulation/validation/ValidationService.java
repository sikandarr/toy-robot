package com.reagroup.toyrobot.simulation.validation;

import java.util.Observer;

/**
 * This interface provides validation service to
 * all Observable objects that register its service.
 * Its an Observer of the observer pattern. 
 * 
 * Whilst its possible to embed the logic of validating
 * an action directly into Action classes - we've decoupled
 * this responsibility from Action classes. This allows
 * greater extensibility of both the action and validation services;
 * for example, we can introduce new actions without repeating the
 * code required to validate those actions or impose new restrictions
 * without much change in the existing actions classes.
 *
 */

public interface ValidationService extends Observer
{
	public boolean verify();
}
