import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Client implements Runnable {

	protected Socket conn = null;
	protected ByteBuffer bb = null;
	protected boolean accepting = false;
	private InputStream incoming = null;
	private OutputStream outgoing = null;
	
	Client(ServerSocket ss, int recvBufLen) throws IOException {
		this.bb = ByteBuffer.allocate(recvBufLen);
		System.out.println("Waiting for authentication from client");
		this.conn = ss.accept();
		this.accepting = true;
	}

	@Override
	public void run() {
		try {
			BufferedInputStream bufin = new BufferedInputStream(incoming);
			BufferedOutputStream bufout = new BufferedOutputStream(outgoing);
			byte[] command = new byte[1024];
			bufin.read(command, 0, 1024);
			new CommandsThread(new Command(command));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() throws IOException {
		this.conn.close();
	}

	public boolean canAuthenticate(String authentication) throws IOException {
		this.incoming = conn.getInputStream();
		BufferedInputStream bufin = new BufferedInputStream(incoming);
		byte[] authCode = new byte[88];
		bufin.read(authCode, 0, 88);
		if(authentication.equals(new String(authCode, "UTF8"))) {
			System.out.println("Client Authenticated!");
			return true;
		}
		System.out.println("Client failed to authenticate");
		return false;
	}

	public void respond() {
		// TODO Auto-generated method stub
		
	}

}