package com.reagroup.toyrobot.view;

import java.io.PrintStream;
import java.util.Scanner;
import com.reagroup.toyrobot.controller.Controller;
import lombok.Builder;
import lombok.Setter;

/**
 * This class is a command line implementation
 * of the View interface.
 *
 */

@Builder
public class CommandLine implements View
{
	@Setter
	private Controller controller;
	private PrintStream out;
	private Scanner scan;

	@Override
	public void update(Object response)
	{
		out.println(response);
	}

	public void run()
	{
		out.println(welcomeMessage);
		for (;;)
		{
			if (scan.hasNextLine())
			{
				String command = scan.nextLine();
				controller.handleInput(command);
			}
		}
	}

	@Builder.Default
	private String welcomeMessage = "" +
			"Hi! Please insert coins to begin; nah, just kidding. :) \n"
			+ "Just enter your command (commands are case-sensitive and don't forget PLACE prior to any other command).\n"
			+ "Enter QUIT to quit.";

}
