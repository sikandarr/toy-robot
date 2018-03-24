package com.reagroup.toyrobot;

public interface ValidationService
{
	default public boolean verify()
	{
		return true;
	}
}
