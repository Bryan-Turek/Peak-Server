
public class CommandsThread extends Thread {

	CommandsThread(Command comm) {
		comm.run();
	}
	
}
