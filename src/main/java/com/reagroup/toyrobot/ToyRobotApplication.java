package com.reagroup.toyrobot;

import com.reagroup.toyrobot.controller.Controller;
import com.reagroup.toyrobot.model.Surface;
import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.SquareTable;
import com.reagroup.toyrobot.view.CommandLineUI;

public class ToyRobotApplication
{
	public static void main(String args[])
	{
		Surface table = new SquareTable(5);
		SurfaceObject toyRobot = MockRobot.construct();
		CommandLineUI commandLine = new CommandLineUI();
		Controller controller = new Controller(toyRobot, table, commandLine);
		commandLine.setController(controller);
		commandLine.run();
	}
}
