package com.reagroup.tests;

import com.reagroup.toyrobot.simulation.ToyRobot;
import com.reagroup.toyrobot.simulation.actions.*;
public class ConstructTestRobot
{
	public static ToyRobot construct(String name)
	{
		return new ToyRobot.RobotBuilder().name(name)
				.action(new PlaceAction(null))
				.action(new MoveFowardAction())
				.action(new RotateLeftAction())
				.action(new RotateRightAction())
				.build();
	}
}
