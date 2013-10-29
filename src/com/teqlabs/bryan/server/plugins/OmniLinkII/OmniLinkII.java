package com.teqlabs.bryan.server.plugins.OmniLinkII;

import java.util.Map;

public interface OmniLinkII extends net.xeoh.plugins.base.Plugin {
	@SuppressWarnings("rawtypes")
	Class TYPE = OmniLinkII.class;
	void init();
	@SuppressWarnings("rawtypes")
	String execute(Map o) throws Exception;
	@SuppressWarnings("rawtypes")
	Map getCommands();
	void resetConnection();
}

