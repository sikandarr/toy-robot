package com.reagroup.toyrobot.simulation.validation;

import java.util.Observable;
import java.util.logging.Logger;
import com.reagroup.toyrobot.controller.commands.ReportCommand;
import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.Surface;
import com.reagroup.toyrobot.simulation.actions.Action;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * This class implements ValidationService and provides method definition to check
 * if a given position is valid. The Position object is injected through the update
 * method as part of the Observer pattern in Java. 
 *
 */

@RequiredArgsConstructor
@AllArgsConstructor
public class CheckPositionIsValid implements ValidationService
{
	private static Logger log = Logger.getLogger(ReportCommand.class.getName());
	private Position position;

	@NonNull
	private final Surface surface;

	@Override
	public boolean verify()
	{
		return surface.isPositionWithinBoundary(position);
	}

	@Override
	public void update(Observable actionObject, Object position)
	{
		if (position != null)
		{
			Action action = (Action) actionObject;
			this.position = (Position) position;
			if (action.isProceed())
				action.setProceed(verify());
			else
				log.warning(position + " is not within the boundry of the surface area");
		}
	}
}
