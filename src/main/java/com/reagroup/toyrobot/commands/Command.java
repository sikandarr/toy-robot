package com.reagroup.toyrobot.commands;

import com.reagroup.toyrobot.SurfaceObject;


public interface Command
{
	public abstract void execute(SurfaceObject object); 
}
