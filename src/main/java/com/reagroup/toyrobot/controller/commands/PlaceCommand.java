package com.reagroup.toyrobot.controller.commands;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.actions.PlaceAction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class PlaceCommand implements Command
{
	@NonNull
	private Position location;
	private SurfaceObject object;

	@Override
	public void execute()
	{
		object.performAction(new PlaceAction(this.location));
	}
}
