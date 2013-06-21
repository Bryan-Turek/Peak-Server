import java.io.IOException;
import net.homeip.mleclerc.omnilink.CommunicationException;
import net.homeip.mleclerc.omnilink.NetworkCommunication;
import net.homeip.mleclerc.omnilink.enumeration.ProtocolTypeEnum;
import net.homeip.mleclerc.omnilink.enumeration.SystemTypeEnum;
import net.homeip.mleclerc.omnilink.messagebase.Message;

public class WVUHA {
	
	private final static SystemTypeEnum SYSTEM_TYPE = SystemTypeEnum.HAI_OMNI_PRO_II;
    private final static String IP_ADDRESS = "192.168.1.4";
    private final static int PORT = 4369;
    private final static String PRIVATE_KEY = "a0-4e-e0-2b-4e-9f-9a-e1-04-81-1f-dc-e4-4f-e0-bf";
    private final static ProtocolTypeEnum PROTOCOL_TYPE = ProtocolTypeEnum.HAI_OMNI_LINK_II; // or ProtocolTypeEnum.HAI_OMNI_LINK_II for Omni-Link II

	public static void main(String[] args) {
    
	  try {
		  NetworkCommunication comm = new NetworkCommunication(SYSTEM_TYPE, IP_ADDRESS, PORT, NetworkCommunication.DEFAULT_TIMEOUT, PRIVATE_KEY, PROTOCOL_TYPE);
		  if (PROTOCOL_TYPE == ProtocolTypeEnum.HAI_OMNI_LINK_II) {
			  // Register a listener to receive notifications from the controller
		  comm.addListener(new NetworkCommunication.NotificationListener() {
			  public void notify(Message notification) {
				  System.out.println("Notification: " + notification);
				  }
			  });
		  }
		  new Server().run(comm);
	  } catch (IOException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  } catch (CommunicationException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	  
  	}
  
}