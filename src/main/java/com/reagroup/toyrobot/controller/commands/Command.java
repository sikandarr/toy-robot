package com.reagroup.toyrobot.controller.commands;

import com.reagroup.toyrobot.model.SurfaceObject;

/**
 * This interface represents a Command that is sent by
 * a user. It may seem counter-intuitive and repetitive
 * to have a separate Command and Action classes when 
 * Command functions can directly perform manipulation
 * of properties required to achieve the change in state.
 * 
 * But, commands are not actions and hence it is of benefit
 * to decouple them from the responsibility of performing 
 * specific actions. 
 * 
 * For example, we can introduce new commands that can perform two
 * or more actions sequentially (Rotate 180 Degree, for example), another 
 * example is when a new command is introduced that performs the same action; 
 * or take the REPORT command that doesn't result in any change of state.
 * 
 * With this interface the ability to introduce new Commmands that do not alter state 
 * is made possible.
 * 
 * This interface combined with its implementations use the command design pattern.
 *
 */
public interface Command
{
	public abstract void execute(SurfaceObject object); 
}
