package com.reagroup.toyrobot.view;

import java.io.PrintWriter;
import java.util.Scanner;

import com.reagroup.toyrobot.controller.Controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class CommandLineInterface implements View
{
	@Setter
	private Controller controller;
	
	@NonNull
	private PrintWriter out;
	
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
