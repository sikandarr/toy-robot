package com.reagroup.toyrobot.view;

import java.io.PrintStream;
import java.util.Scanner;

import com.reagroup.toyrobot.controller.Controller;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class CommandLine implements View
{
	@NonNull
	private Controller controller;
	
	@NonNull
	private PrintStream out;
	
	@NonNull
	private Scanner scan;

	@Override
	public void update(Object response)
	{
		out.println(response);
	}

	public void run()
	{
		try (Scanner scanner = new Scanner(System.in))
		{
			System.out.println("Command:");
			String command = "";
			for (; !command.equals("QUIT");)
			{
				command = scanner.nextLine();
				controller.handleInput(command);
			}
		}
	}

}
