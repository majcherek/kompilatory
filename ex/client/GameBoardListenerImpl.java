package client;

import java.rmi.RemoteException;

import remotes.GameBoard;
import remotes.GameBoardListener;
import remotes.UserRejectedException;

public class GameBoardListenerImpl {
	
		public void onNewMove() throws RemoteException {};
		public void onWrongMove() throws RemoteException {};
		public void onGameWon() throws RemoteException {};
		public void onWrongTurn() throws RemoteException {};
		public void onNewTurn() throws RemoteException {};
		public void onDraw() throws RemoteException {};

}
