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
			else
				break;
		}
		scan.close();
	}

	@Builder.Default
	@Setter
	private String welcomeMessage = "" +
			"Hi! Please insert a coin to begin or you may even enter a command (commands are case-sensitive)\n"
			+ "CTRL+C to quit.";

}
