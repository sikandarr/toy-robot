package com.reagroup.toyrobot.view;

import java.util.Scanner;

import com.reagroup.toyrobot.controller.Controller;

import lombok.Setter;

public class CommandLineUI
{
	@Setter
	Controller controller;

	public void update(String response)
	{
		System.out.println(response);
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
