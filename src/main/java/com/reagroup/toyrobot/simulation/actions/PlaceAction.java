package com.reagroup.toyrobot.simulation.actions;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlaceAction extends Action
{
	// new position
	private Position position;

	@Override
	public void performAction(SurfaceObject object)
	{
		notifyObservers(position);
		if (proceed)
			object.setPosition(position);
	}

}
