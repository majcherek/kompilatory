import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP extends BlahBlah implements Interface1, Inteface2, ITest {

	/**
	 * @param args
	 */
	public int port;
	private String IP;
	protected String[] IPparts;
	private SecondClass second;
	byte[] IPbyte;
	byte bytes[];
	
	public static int main(String[] args) {

		if (args.length != 2) {
			System.out.println("Input parameters: <IP> <port>");
			System.exit(-1);
		}
		
		int port = Integer.parseInt(args[1]);
		String IP = args[0];
		String[] IPparts = IP.split("\\.");

		byte[] IPbyte = new byte[]{(byte) Integer.parseInt(IPparts[0]), (byte) Integer.parseInt(IPparts[1]), (byte) Integer.parseInt(IPparts[2]), (byte) Integer.parseInt(IPparts[3])};
		

		try {
			InetAddress address = InetAddress.getByAddress(IPbyte);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public abstract String getSth(){
		return "sth";
	}
	
	public abstract void setSth(String a, int b){

	}
}

