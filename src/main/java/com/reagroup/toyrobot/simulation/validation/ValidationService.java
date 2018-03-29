package com.reagroup.toyrobot.simulation.validation;

import java.util.Observer;

/**
 * This interface provides validation service to
 * all Observable objects that register its service
 *
 */

public interface ValidationService extends Observer
{
	public boolean verify();
}
