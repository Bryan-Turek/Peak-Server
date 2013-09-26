package com.teqlabs.bryan.server.plugins.OmniLinkII.OmniLinkIIImpl;

import java.util.Map;

import net.homeip.mleclerc.omnilink.CommunicationException;
import net.homeip.mleclerc.omnilink.enumeration.ProtocolTypeEnum;
import net.homeip.mleclerc.omnilink.enumeration.SystemTypeEnum;
import net.homeip.mleclerc.omnilink.messagebase.CommandMessage;
import net.homeip.mleclerc.omnilink.messagebase.MessageHelper;

@SuppressWarnings("serial")
public class LightControlCommand extends CommandMessage {
	private int unit;
	private int state;
	private int time;
    
	@SuppressWarnings("rawtypes")
	public LightControlCommand(Map o) {
    	this.unit = ((Long) o.get("unit")).intValue();
    	this.state  = ((Long) o.get("state")).intValue();
    	this.time = ((Long) o.get("time") != null) ? ((Long) o.get("state")).intValue() : 0;
    }
    
	protected void initialize(SystemTypeEnum model,	ProtocolTypeEnum protocolType) throws CommunicationException {
        MessageHelper.validateValue(unit, 1, 255);
        MessageHelper.validateValue(state, 0, 1);
        MessageHelper.validateValue(time, 0, 218);
        
        super.initialize(model, protocolType, state, time, unit);
        
	}
}

