package com.reagroup.toyrobot.simulation;

import com.reagroup.toyrobot.model.SurfaceObject;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CheckObjectIsPlaced implements ValidationService
{
	private final SurfaceObject object;
	
	@Override
	public boolean verify()
	{
		return object.getLocation() != null;
	}

}
