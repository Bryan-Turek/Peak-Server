package com.teqlabs.bryan.server.plugins.OmniLinkII.OmniLinkIIImpl;

import java.util.Map;

import net.homeip.mleclerc.omnilink.CommunicationException;
import net.homeip.mleclerc.omnilink.enumeration.ProtocolTypeEnum;
import net.homeip.mleclerc.omnilink.enumeration.SystemTypeEnum;
import net.homeip.mleclerc.omnilink.messagebase.CommandMessage;
import net.homeip.mleclerc.omnilink.messagebase.MessageHelper;

@SuppressWarnings("serial")
public class AudioSourceCommand extends CommandMessage {
	private int zone;
	private int source = -1;
    
	@SuppressWarnings("rawtypes")
	public AudioSourceCommand(Map o) {
    	this.zone = ((Long) o.get("zone")).intValue();
    	this.source  = ((Long) o.get("source")).intValue();
    }
    
	protected void initialize(SystemTypeEnum model,	ProtocolTypeEnum protocolType) throws CommunicationException {
		MessageHelper.validateValue(source, 1, 9);
        MessageHelper.validateValue(zone, 1, 9);
        
        super.initialize(model, protocolType, 114, source, zone);
        
	}
}