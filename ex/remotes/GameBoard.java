package remotes;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface GameBoard extends Remote {
	public void makeMove(User user, int fieldId) throws RemoteException,
			UserRejectedException;

	public void register(User u, GameBoardListener l) throws RemoteException,
			UserRejectedException;

	public String getCurrentBoard() throws RemoteException,
			UserRejectedException;
	
	public boolean isSlotFree() throws RemoteException;
	
}