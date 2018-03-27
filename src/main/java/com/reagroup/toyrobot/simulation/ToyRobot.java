package com.reagroup.toyrobot.simulation;

import java.util.List;

import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.actions.Action;


public class ToyRobot extends SurfaceObject
{
	public ToyRobot(String name, List<Action> actions)
	{
		super(name, actions);
	}
	
}
