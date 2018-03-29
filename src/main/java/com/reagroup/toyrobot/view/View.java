package com.reagroup.toyrobot.view;


/**
 * The View interface of the MVC architecture;
 * through this interface we open door to different kinds of
 * View technologies (web interface for example).
 *
 */
public interface View
{
	public void update(Object response);
}
