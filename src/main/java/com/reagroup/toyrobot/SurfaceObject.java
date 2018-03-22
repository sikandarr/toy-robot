package com.reagroup.toyrobot;

import java.util.List;

import com.reagroup.toyrobot.actions.AbstractAction;

import lombok.Data;

@Data
public abstract class SurfaceObject
{
	private Position location;
	private List<AbstractAction> actions;
}
