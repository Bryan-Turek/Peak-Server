import java.io.UnsupportedEncodingException;

public class Command implements Runnable {

	private String command;

	public Command(byte[] c) throws UnsupportedEncodingException {
		this.command = new String(c, "US-ASCII");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.execute();
	}
	
	public void execute() {
		System.out.println(this.command);
	}
	
}
