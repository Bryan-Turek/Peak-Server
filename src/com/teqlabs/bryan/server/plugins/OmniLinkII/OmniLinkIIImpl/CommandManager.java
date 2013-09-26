package com.teqlabs.bryan.server.plugins.OmniLinkII.OmniLinkIIImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.TreeMap;

import net.homeip.mleclerc.omnilink.messagebase.RequestMessage;

public class CommandManager {
	
	@SuppressWarnings("rawtypes")
	private Map<String, Class> commandMap = new TreeMap<String, Class>();
	
	public CommandManager() {
		commandMap.put("audio.volume", AudioVolumeCommand.class);
		commandMap.put("audio.source", AudioSourceCommand.class);
		commandMap.put("audio.control", AudioControlCommand.class);
		commandMap.put("light.control", LightControlCommand.class);
		commandMap.put("light.level", LightLevelCommand.class);
		commandMap.put("security", SecurityCommand.class);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	/*
	 * This creates a request message from the omnilink.jar library.
	 * This function needs to be cleaned up.
	 */
	public RequestMessage createRequestMessage(Map o) {
        
        Class commandClass = commandMap.get(o.get("command"));
        
        try {
        	Constructor constr = commandClass.getConstructor(Map.class);
			return (RequestMessage) constr.newInstance((Map) o.get("params"));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.getCause();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
        
	}
	
	@SuppressWarnings("rawtypes")
	public Map getCommands() {
		return this.commandMap;
	}

}
