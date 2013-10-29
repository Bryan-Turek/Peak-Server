package com.teqlabs.bryan.server.plugins.OmniLinkII.OmniLinkIIImpl;

import net.homeip.mleclerc.omnilink.MessageManager;
import net.homeip.mleclerc.omnilink.message.SystemStatusRequest;
import net.homeip.mleclerc.omnilink.messagebase.ReplyMessage;

public class PollingThread extends Thread {

	private MessageManager comm;
	
	public PollingThread(MessageManager comm) {
		this.comm = comm;
	}
	
	public void run() {
		ReplyMessage sysinfo;
		try {
			while(comm.isOpen()) {
				sysinfo = comm.execute(new SystemStatusRequest());
				System.out.println(sysinfo);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
