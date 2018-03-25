package com.reagroup.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.reagroup.toyrobot.model.Direction;

public class TestDirection
{
	private static Direction facing;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		facing = Direction.NORTH;
	}

	@Test
	public void testAllRotations()
	{
		facing = facing.turnLeft();
		assertEquals(Direction.WEST, facing);
		
		facing = facing.turnLeft();
		assertEquals(Direction.SOUTH, facing);
		
		facing = facing.turnLeft();
		assertEquals(Direction.EAST, facing);
		
		facing = facing.turnLeft();
		assertEquals(Direction.NORTH, facing);
		
		facing = facing.turnRight();
		assertEquals(Direction.EAST, facing);
		
		facing = facing.turnRight();
		assertEquals(Direction.SOUTH, facing);
		
		facing = facing.turnRight();
		assertEquals(Direction.WEST, facing);
		
		facing = facing.turnRight();
		assertEquals(Direction.NORTH, facing);
	}

}
