package com.reagroup.toyrobot.view;

import java.io.PrintStream;
import java.util.Scanner;
import com.reagroup.toyrobot.controller.Controller;
import lombok.Builder;
import lombok.Setter;

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
		System.out.println("Command:");
		String command = "";
		for (; !command.equals("QUIT");)
		{
			command = scan.nextLine();
			controller.handleInput(command);
		}
	}

}
