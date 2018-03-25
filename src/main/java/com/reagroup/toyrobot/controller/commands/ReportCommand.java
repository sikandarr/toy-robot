package com.reagroup.toyrobot.controller.commands;

import java.io.PrintStream;

import com.reagroup.toyrobot.model.SurfaceObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ReportCommand implements Command
{
	@NonNull
	PrintStream out;
	private SurfaceObject object;
	
	@Override
	public void execute()
	{
		try
		{
			out.println(object.getPosition().toString());
		}
		catch(NullPointerException ex)
		{
			
		}
	}
	
}
