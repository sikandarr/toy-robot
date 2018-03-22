package com.reagroup.toyrobot.actions;

import com.reagroup.toyrobot.Position;

import lombok.Data;

@Data
public abstract class AbstractAction
{
	Position location;
	abstract void perform();
}
