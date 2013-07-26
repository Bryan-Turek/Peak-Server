package com.teqlabs.bryan.server;

import java.util.ArrayList;
import java.util.Collection;

public class Message {
	
	private String node = null;
	private String command = null;
	
	@SuppressWarnings("rawtypes")
	private Collection params = new ArrayList();
	
	public Message() {
	}
	
	@SuppressWarnings("rawtypes")
	public Message(String node, String command, ArrayList params) {
		this.node = node;
		this.command = command;
		this.params = params;
	}

	public String getNode() {
		// TODO Auto-generated method stub
		return node;
	}
	
	public String getCommand() {
		return command;
	}
	
	@SuppressWarnings("rawtypes")
	public Collection getParams() {
		return params;
	}

}
