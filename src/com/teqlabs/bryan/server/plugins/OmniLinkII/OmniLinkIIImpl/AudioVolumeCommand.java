package com.teqlabs.bryan.server.plugins.OmniLinkII.OmniLinkIIImpl;

import java.util.Map;

import net.homeip.mleclerc.omnilink.CommunicationException;
import net.homeip.mleclerc.omnilink.enumeration.ProtocolTypeEnum;
import net.homeip.mleclerc.omnilink.enumeration.SystemTypeEnum;
import net.homeip.mleclerc.omnilink.messagebase.CommandMessage;
import net.homeip.mleclerc.omnilink.messagebase.MessageHelper;

@SuppressWarnings("serial")
public class AudioVolumeCommand extends CommandMessage {
	private int zone;
	private int volume;
    
	@SuppressWarnings("rawtypes")
	public AudioVolumeCommand(Map o) {
    	this.zone = ((Long) o.get("zone")).intValue();
    	this.volume  = ((Long) o.get("volume")).intValue();
    }
    
	protected void initialize(SystemTypeEnum model,	ProtocolTypeEnum protocolType) throws CommunicationException {
        MessageHelper.validateValue(volume, 0, 100);
        MessageHelper.validateValue(zone, 1, 9);
        
        super.initialize(model, protocolType, 113, volume, zone);
        
	}
}
