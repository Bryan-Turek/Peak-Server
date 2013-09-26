package com.teqlabs.bryan.server.plugins.OmniLinkII.OmniLinkIIImpl;

import java.util.Map;

import net.homeip.mleclerc.omnilink.CommunicationException;
import net.homeip.mleclerc.omnilink.enumeration.ProtocolTypeEnum;
import net.homeip.mleclerc.omnilink.enumeration.SystemTypeEnum;
import net.homeip.mleclerc.omnilink.messagebase.CommandMessage;
import net.homeip.mleclerc.omnilink.messagebase.MessageHelper;

@SuppressWarnings("serial")
public class AudioControlCommand extends CommandMessage {
	private int zone;
	private int state;
    
	@SuppressWarnings("rawtypes")
	public AudioControlCommand(Map o) {
    	this.zone = ((Long) o.get("zone")).intValue();
    	this.state  = ((Long) o.get("state")).intValue();
    }
    
	protected void initialize(SystemTypeEnum model,	ProtocolTypeEnum protocolType) throws CommunicationException {
        MessageHelper.validateValue(state, 0, 3);
        MessageHelper.validateValue(zone, 0, 9);
        
        super.initialize(model, protocolType, 112, state, zone);
        
	}
}
