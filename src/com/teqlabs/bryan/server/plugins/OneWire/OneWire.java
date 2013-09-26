package com.teqlabs.bryan.server.plugins.OneWire;

import java.util.Map;

public interface OneWire extends net.xeoh.plugins.base.Plugin {
	@SuppressWarnings("rawtypes")
	Class TYPE = OneWire.class;
	void init();
	@SuppressWarnings("rawtypes")
	String execute(Map o) throws Exception;
}