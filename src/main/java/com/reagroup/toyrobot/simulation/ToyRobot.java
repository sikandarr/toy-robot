package com.reagroup.toyrobot.simulation;

import java.util.ArrayList;
import java.util.List;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.actions.Action;

public class ToyRobot extends SurfaceObject
{
	private ToyRobot(Position position, String name, List<Action> actions)
	{
		this.position = position;
		this.name = name;
		this.actions = actions;
	}

	@Override
	public void performAction(Action action)
	{
		for (Action performable : actions)
			if (action.getClass().equals(performable.getClass()))
				action.performAction(this);
	}

	public static class RobotBuilder
	{
		private Position position;
		private String name;
		private List<Action> actions;

		public RobotBuilder()
		{
			actions = new ArrayList<>();
			name = "Robot";
		}

		public RobotBuilder position(Position position)
		{
			this.position = position;
			return this;
		}

		public RobotBuilder name(String name)
		{
			this.name = name;
			return this;
		}

		public RobotBuilder action(Action action)
		{
			if (actions.indexOf(action) == -1)
				actions.add(action);
			return this;
		}

		public ToyRobot build()
		{
			return new ToyRobot(position, name, actions);
		}
	}
}
