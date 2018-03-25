package com.reagroup.toyrobot.simulation.actions;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlaceAction extends Action
{
	// new position
	private Position position;

	@Override
	public void performAction(SurfaceObject object)
	{
		setChanged();
		notifyObservers(position);
		if (proceed)
			object.setPosition(position);
	}

}
