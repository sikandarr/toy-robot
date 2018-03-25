package com.reagroup.toyrobot.simulation.validation;

import java.util.Observer;

public interface ValidationService extends Observer
{
	public boolean verify();
}
