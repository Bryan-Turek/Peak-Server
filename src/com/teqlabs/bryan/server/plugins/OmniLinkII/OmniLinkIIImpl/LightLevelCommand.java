package com.teqlabs.bryan.server.plugins.OmniLinkII.OmniLinkIIImpl;

import java.util.Map;

import net.homeip.mleclerc.omnilink.CommunicationException;
import net.homeip.mleclerc.omnilink.enumeration.ProtocolTypeEnum;
import net.homeip.mleclerc.omnilink.enumeration.SystemTypeEnum;
import net.homeip.mleclerc.omnilink.messagebase.CommandMessage;
import net.homeip.mleclerc.omnilink.messagebase.MessageHelper;

@SuppressWarnings("serial")
public class LightLevelCommand extends CommandMessage {
	private int unit;
	private int level;
    
	@SuppressWarnings("rawtypes")
	public LightLevelCommand(Map o) {
    	this.unit = ((Long) o.get("unit")).intValue();
    	this.level  = ((Long) o.get("level")).intValue();
    }
    
	protected void initialize(SystemTypeEnum model,	ProtocolTypeEnum protocolType) throws CommunicationException {
        MessageHelper.validateValue(unit, 1, 255);
        MessageHelper.validateValue(level, 0, 100);
        
        super.initialize(model, protocolType, 9, level, unit);
        
	}
}