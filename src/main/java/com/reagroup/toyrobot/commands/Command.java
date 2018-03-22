package com.reagroup.toyrobot.commands;

import com.reagroup.toyrobot.SurfaceObject;
import lombok.Data;

@Data
public abstract class Command
{
	public abstract void execute(SurfaceObject object); 
}
