package com.reagroup.toyrobot.commands;

import java.io.PrintStream;

import com.reagroup.toyrobot.SurfaceObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class ReportCommand implements Command
{
	PrintStream out;
	
	@Override
	public void execute(SurfaceObject object)
	{
		out.println(object.getLocation().toString());
	}
	
}
