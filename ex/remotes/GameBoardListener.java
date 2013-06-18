package remotes;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameBoardListener extends Remote {
	public void onNewMove(GameBoard board) throws RemoteException;
	public void onWrongMove() throws RemoteException;
	public void onGameWon(GameBoard board, char symbol) throws RemoteException;
	public void onWrongTurn() throws RemoteException;
	public void onNewTurn() throws RemoteException;
	public void onDraw() throws RemoteException;
}