package remotes;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface User extends Remote {
	public String getNick() throws RemoteException;
	public char getSymbol() throws RemoteException;
	public void setSymbol(char s) throws RemoteException;
}