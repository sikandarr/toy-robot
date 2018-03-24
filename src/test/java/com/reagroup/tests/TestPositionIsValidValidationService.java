package com.reagroup.tests;

import org.junit.Test;

import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.model.Surface;
import com.reagroup.toyrobot.simulation.CheckPositionIsValid;
import com.reagroup.toyrobot.simulation.SquareTable;
import com.reagroup.toyrobot.simulation.ValidationService;

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
