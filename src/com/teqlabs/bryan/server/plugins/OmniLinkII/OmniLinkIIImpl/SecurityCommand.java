package com.teqlabs.bryan.server.plugins.OmniLinkII.OmniLinkIIImpl;

import java.util.Map;

import net.homeip.mleclerc.omnilink.CommunicationException;
import net.homeip.mleclerc.omnilink.enumeration.ProtocolTypeEnum;
import net.homeip.mleclerc.omnilink.enumeration.SecurityModeEnum;
import net.homeip.mleclerc.omnilink.enumeration.SystemTypeEnum;
import net.homeip.mleclerc.omnilink.message.MessageConstants;
import net.homeip.mleclerc.omnilink.messagebase.CommandMessage;
import net.homeip.mleclerc.omnilink.messagebase.MessageHelper;

@SuppressWarnings("serial")
public class SecurityCommand extends CommandMessage {
	private int area;
	private SecurityModeEnum mode;
	private int code;

    @SuppressWarnings("rawtypes")
	public SecurityCommand(Map o) {
    	this.area = ((Long) o.get("area") != null) ? ((Long) o.get("area")).intValue() : MessageConstants.DEFAULT_AREA;
    	this.mode = (SecurityModeEnum) o.get("mode");
    	this.code = ((Long) o.get("code") != null) ? ((Long) o.get("code")).intValue() : MessageConstants.DEFAULT_USER_CODE;
    }

	protected void initialize(SystemTypeEnum model, ProtocolTypeEnum protocolType) throws CommunicationException {
        MessageHelper.validateEnum(mode);
        MessageHelper.validateValue(code, 1, 255);
        MessageHelper.validateValue(area, 1, 16);

        super.initialize(model, protocolType, 48 + mode.getValue(), code, area);
	}
}
