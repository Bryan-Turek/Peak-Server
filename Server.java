import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import net.homeip.mleclerc.omnilink.CommunicationException;
import net.homeip.mleclerc.omnilink.NetworkCommunication;

public class Server {
  
  private final static int RECV_BUF_LEN = 1024; // receive buffer length
  
  private Configuration config = new Configuration(); // default configuration for the server
  private List<Client> clients = new ArrayList<Client>();
  private boolean running = false; // specifies if server is running

  public Server() { // create server from default configuration settings
  }

  public Server(Configuration c) { // create server from configuration
    this.config = c;
  }
  
  public void run(NetworkCommunication comm) throws IOException, CommunicationException {
	  
	comm.open();
    
	ServerSocket ss = new ServerSocket(config.port, 0, InetAddress.getByName("0.0.0.0"));
	System.out.println("Server running on port: " + config.port);
	Client client = new Client(ss, RECV_BUF_LEN);
	
	while(client.accepting) {
		if(client.canAuthenticate(config.authentication)) {
			this.clients.add(client);
			new ClientThread(client);
		} else {
			client.close(); // close connection to client because it can't authenticate
		}
		client = new Client(ss, RECV_BUF_LEN); // create new client
	}
    
  }
  
  public boolean isRunning() {
	return this.running;
  }
  
  public void stop() {
	  
  }

}