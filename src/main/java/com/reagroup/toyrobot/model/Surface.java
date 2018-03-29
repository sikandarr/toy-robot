package com.reagroup.toyrobot.model;

/**
 * The Surface interface represents a plane on which 
 * the objects of our universe exist; there's not much known
 * about the Surface - it could, for example, be a square,
 * a circle, a pentagon, or even the white house, it doesn't matter.
 * What matters is that any implementation of this artifact be able to
 * tell us whether a given position is within its boundary.
 * 
 * Note: implementations that are one dimensional should necessarily
 * render all positions that have the other dimension greater or less 
 * than zero beyond its boundary.
 *
 */
public interface Surface
{
	public boolean isPositionWithinBoundary(Position location);
}
