package com.teqlabs.bryan.server;

public class ClientThread extends Thread {
	
	private Client client;

	public ClientThread(Client c) {
		this.client = c;
	}
	
	public void run(){
		this.client.run();
	}

}
