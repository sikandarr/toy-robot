package com.reagroup.toyrobot.controller.commands;

import java.util.logging.Logger;
import java.util.logging.Level;

import com.reagroup.toyrobot.model.SurfaceObject;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * This class implements the Command interface to
 * implement the functionality of the REPORT command
 * which reports on the position of the SurfaceObject.
 * 
 * Note: the execute() method must be called for the object
 * of this class to be ready to return a meaningful response
 * via the getResponse method();
 *
 */

@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReportCommand implements Command
{
	private static Logger log = Logger.getLogger(ReportCommand.class.getName());
	private String response;

	@NonNull
	private final SurfaceObject object;

	@Override
	public void execute()
	{
		try
		{
			response = object.getPosition().toString();
		}
		catch (NullPointerException ex)
		{
			response = object.getName() + " Not Placed";
		}
	}

	public String getResponse()
	{
		if (response != null)
			return response;
		else
		{
			log.log(Level.SEVERE, "ReportCommand: execute() must be called before getResponse()");
			return "";
		}
	}

}
