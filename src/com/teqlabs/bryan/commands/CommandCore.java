package com.teqlabs.bryan.commands;

import java.util.Map;
import java.util.TreeMap;

import net.xeoh.plugins.base.Plugin;
import net.xeoh.plugins.base.PluginManager;

import com.teqlabs.bryan.server.plugins.OmniLinkII.OmniLinkII;

public class CommandCore {
	
	@SuppressWarnings("rawtypes")
	private Map<String, Class> pluginMap = new TreeMap<String, Class>();

	public CommandCore() {
		pluginMap.put("omnilink", OmniLinkII.class);
		//pluginMap.put("onewire", OneWire.class);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void execute(Map o, PluginManager pm) {
		Class pClass = pluginMap.get(o.get("node"));
		Plugin plugin = pm.getPlugin(pClass);
		try {
			if(pClass == OmniLinkII.TYPE)
				((OmniLinkII) plugin).execute(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
