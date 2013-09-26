package com.teqlabs.bryan.commands;

public class CommandThread extends Thread {

	private Command command;

	public CommandThread(Command c) {
		this.command = c;
	}
	
	public void run(){
		this.command.run();
	}
	
}
