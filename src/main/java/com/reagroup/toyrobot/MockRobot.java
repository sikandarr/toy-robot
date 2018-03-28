package com.reagroup.toyrobot;

import java.util.ArrayList;

import com.reagroup.toyrobot.simulation.ToyRobot;
import com.reagroup.toyrobot.simulation.actions.*;

public class MockRobot
{
	public static ToyRobot construct()
	{
		ToyRobot toyRobot = new ToyRobot("Mock Toy Robot", new ArrayList<Action>());
		toyRobot.addAction(new PlaceAction(null));
		toyRobot.addAction(new MoveFowardAction());
		toyRobot.addAction(new RotateLeftAction());
		toyRobot.addAction(new RotateRightAction());
		return toyRobot;
	}
}
