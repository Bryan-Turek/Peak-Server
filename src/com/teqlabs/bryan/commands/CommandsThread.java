package com.teqlabs.bryan.commands;

public class CommandsThread extends Thread {

	private Command command;

	public CommandsThread(Command c) {
		this.command = c;
	}
	
	public void run(){
		this.command.run();
	}
	
}
