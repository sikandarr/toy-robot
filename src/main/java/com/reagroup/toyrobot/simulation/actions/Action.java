package com.reagroup.toyrobot.simulation.actions;

import java.util.Observable;
import com.reagroup.toyrobot.model.SurfaceObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Action extends Observable
{
	protected boolean proceed = true;

	public abstract void performAction(SurfaceObject object);
}
