import java.io.IOException;

import com.teqlabs.bryan.server.Server;

public class WVUHA {
	
	public static void main(String[] args) {
    
	  try {
		  
		  //create server
		  Server s = new Server();
		  
		  //load server plugins
		  s.loadPlugins();
		  
		  //finally start the server
		  s.run();
		  
	  } catch (IOException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	  
  	}
  
}