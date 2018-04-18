package com.reagroup.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.reagroup.toyrobot.model.Direction;
import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.simulation.CollisionDetectableSquareTable;
import com.reagroup.toyrobot.simulation.actions.Action;
import com.reagroup.toyrobot.simulation.actions.MoveFowardAction;
import com.reagroup.toyrobot.simulation.validation.ValidationService;

public class TestCheckCollision
{
	private static ValidationService checkCollision;
	private static CollisionDetectableSquareTable squareTable;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		squareTable = new CollisionDetectableSquareTable(5);
		checkCollision = new CheckCollision(squareTable);
	}

	@Test
	public void testCheckCollisonValidationServiceDetectsCollision()
	{
		List<Position> positionList = new ArrayList<>();
		Position position1 = new Position(0,0,Direction.NORTH);
		Position position2 = new Position(0,0,Direction.NORTH);
		positionList.add(position1);
		positionList.add(position2);
		Action move = new MoveFowardAction();
		checkCollision.update(move, positionList);
		assertEquals(true, move.isProceed());
	}
	
	@Test
	public void testCheckCollisonValidationServiceDetectsNoCollisionWhenPositionNotSame()
	{
		List<Position> positionList = new ArrayList<>();
		Position position1 = new Position(0,0,Direction.NORTH);
		Position position2 = new Position(0,1,Direction.NORTH);
		positionList.add(position1);
		positionList.add(position2);
		Action move = new MoveFowardAction();
		checkCollision.update(move, positionList);
		assertEquals(false, move.isProceed());
	}

}
