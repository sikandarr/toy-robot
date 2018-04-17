package com.reagroup.toyrobot.model;

public interface CollissionDetectableSurface extends Surface
{
	public boolean detectCollision(Position position1, Position position2);
}
