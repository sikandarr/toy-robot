package com.reagroup.toyrobot.controller.commands;

import java.io.PrintStream;

import com.reagroup.toyrobot.model.SurfaceObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class ReportCommand implements Command
{
	PrintStream out;
	private SurfaceObject object;
	
	@Override
	public void execute()
	{
		out.println(object.getLocation().toString());
	}
	
}
