package com.teqlabs.bryan.commands;

import java.util.Map;
import java.util.TreeMap;

import com.teqlabs.bryan.OmniLinkII.OmniLinkII;

public class CommandCore {
	
	@SuppressWarnings("rawtypes")
	private Map<String, Class> pluginMap = new TreeMap<String, Class>();

	public CommandCore() {
		pluginMap.put("omnilink", OmniLinkII.class);
	}

	@SuppressWarnings("rawtypes")
	public Class find(String c) {
		return pluginMap.get(c);
	}
	
}
