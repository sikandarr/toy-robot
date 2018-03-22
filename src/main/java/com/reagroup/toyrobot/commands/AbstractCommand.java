package com.reagroup.toyrobot.commands;

import com.reagroup.toyrobot.SurfaceObject;
import lombok.Data;

@Data
public abstract class AbstractCommand
{
	SurfaceObject object;
	public abstract void runCommand(); 
}
