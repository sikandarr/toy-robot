package com.reagroup.toyrobot.simulation;

public interface ValidationService
{
	default public boolean verify()
	{
		return true;
	}
}
