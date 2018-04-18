package com.reagroup.tests;

import java.util.List;
import java.util.Observable;

import com.reagroup.toyrobot.model.Position;
import com.reagroup.toyrobot.simulation.CollisionDetectableSquareTable;
import com.reagroup.toyrobot.simulation.actions.Action;
import com.reagroup.toyrobot.simulation.validation.ValidationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckCollision implements ValidationService
{
	private final CollisionDetectableSquareTable surface;
	private List<Position> positions;

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable actionObject, Object positionList)
	{
		Action action = (Action) actionObject;
		this.positions = (List<Position>) positionList;
		if (action.isProceed())
			action.setProceed(verify());

	}

	@Override
	public boolean verify()
	{
		return surface.detectCollision(positions.get(0), positions.get(1));
	}

}
