package com.reagroup.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.reagroup.toyrobot.model.CollissionDetectableSurface;
import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.simulation.CollisionDetectableSquareTable;

public class TestCollisionDetectableSurface
{
	private static CollissionDetectableSurface surface;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		surface = new CollisionDetectableSquareTable(5);
		
	}

	@Test
	public void test()
	{
		Position position1 = new Position(0,0,Direction.NORTH);
		Position position2 = new Position(0,0,Direction.NORTH);
		assertEquals(true, surface.detectCollision(position1, position2));
	}

}
