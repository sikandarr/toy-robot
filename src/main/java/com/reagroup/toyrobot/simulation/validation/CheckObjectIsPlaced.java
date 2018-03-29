package com.reagroup.toyrobot.simulation.validation;

import java.util.Observable;
import java.util.logging.Logger;
import com.reagroup.toyrobot.controller.commands.ReportCommand;
import com.reagroup.toyrobot.model.SurfaceObject;
import com.reagroup.toyrobot.simulation.actions.Action;

import lombok.AllArgsConstructor;

/**
 * A ValidationService that checks if a Surface Objects has been placed;
 * the SurfaceObject is injected through the constrtcutor.
 *
 */

@AllArgsConstructor
public class CheckObjectIsPlaced implements ValidationService
{
	private static Logger log = Logger.getLogger(ReportCommand.class.getName());
	private final SurfaceObject surfaceObject;

	@Override
	public boolean verify()
	{
		return surfaceObject.getPosition() != null;
	}

	@Override
	public void update(Observable actionObject, Object arg)
	{
		Action action = (Action) actionObject;
		if (action.isProceed())
			action.setProceed(verify());
		else
			log.warning(surfaceObject + " has not ben placed");
	}
}
