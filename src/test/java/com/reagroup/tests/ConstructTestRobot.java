package com.reagroup.tests;

import com.reagroup.toyrobot.simulation.ToyRobot;
import com.reagroup.toyrobot.simulation.actions.*;
public class ConstructTestRobot
{
	public static ToyRobot construct(String name)
	{
		return new ToyRobot.RobotBuilder().name(name)
				.addAction(new PlaceAction(null))
				.addAction(new MoveFowardAction())
				.addAction(new RotateLeftAction())
				.addAction(new RotateRightAction())
				.create();
	}
}
