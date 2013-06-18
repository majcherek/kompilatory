package remotes;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Server extends Remote {
	
	public GameBoard connect(boolean isAI) throws RemoteException;

}
