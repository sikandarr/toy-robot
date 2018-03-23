package com.reagroup.tests;

import org.junit.Test;

import com.reagroup.toyrobot.CheckPositionIsValid;
import com.reagroup.toyrobot.Direction;
import com.reagroup.toyrobot.Position;
import com.reagroup.toyrobot.SquareTable;
import com.reagroup.toyrobot.Surface;
import com.reagroup.toyrobot.ValidationService;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;

public class TestPositionIsValidValidationService
{
	private static Surface squareTable;
	
	@BeforeClass
	public static void setUp()
	{
		squareTable = new SquareTable(5);
	}
	
	@Test
	public void testValidPositions()
	{
		ValidationService service = new CheckPositionIsValid(new Position (5, 5, Direction.NORTH), squareTable);
		assertEquals(true, service.verify());
		
		service = new CheckPositionIsValid(new Position (0, 1, Direction.NORTH),squareTable);
		assertEquals(true, service.verify());
	}
	
	@Test
	public void testInvalidPositions()
	{
		ValidationService service = new CheckPositionIsValid(new Position (6, 5, Direction.NORTH), squareTable);
		assertEquals(false, service.verify());
		
		service = new CheckPositionIsValid(new Position (5, 6, Direction.NORTH), squareTable);
		assertEquals(false, service.verify());
		
		service = new CheckPositionIsValid(new Position (-1, 0, Direction.NORTH), squareTable);
		assertEquals(false, service.verify());
	}
}
