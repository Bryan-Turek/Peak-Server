
public class ClientThread extends Thread {
	
	ClientThread(Client c) {
		c.run();
	}

}
