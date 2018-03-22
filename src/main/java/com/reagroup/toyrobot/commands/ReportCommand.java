package com.reagroup.toyrobot.commands;

import java.io.PrintStream;

import com.reagroup.toyrobot.SurfaceObject;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReportCommand extends Command
{
	PrintStream out;
	
	@Override
	public void execute(SurfaceObject object)
	{
		out.println(object.getLocation().toString());
	}
	
}
