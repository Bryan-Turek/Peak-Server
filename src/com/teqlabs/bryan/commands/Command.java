package com.teqlabs.bryan.commands;

import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.xeoh.plugins.base.PluginManager;

public class Command implements Runnable {

	private PluginManager pm;
	private Logger log;
	private String json;
	private CommandCore commands;

	public Command(String json, CommandCore c, PluginManager pm, Logger log) {
		this.json = json;
		this.commands = c;
		this.pm = pm;
		this.log = log;
	}

	@Override
	public void run() {
		
		//Parse json object
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject obj = (JSONObject) parser.parse(json.trim());
			this.log.info(obj.toString());
			
			commands.execute(obj, pm);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
